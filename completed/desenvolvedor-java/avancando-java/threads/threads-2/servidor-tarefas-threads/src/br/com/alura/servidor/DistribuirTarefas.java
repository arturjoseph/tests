package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool;
	private BlockingQueue<String> filaComando;

	public DistribuirTarefas(Socket socket, ServidorTarefas servidor, ExecutorService threadPool, BlockingQueue<String> filaComando) {
		this.socket = socket;
		this.servidor = servidor;
		this.threadPool = threadPool;
		this.filaComando = filaComando;
	}

	@Override
	public void run() {
		System.out.println("Distribuindo tarefas para: " + socket);

		try {
			Scanner entrada = new Scanner(socket.getInputStream());
			PrintStream saida = new PrintStream(socket.getOutputStream());

			while (entrada.hasNextLine()) {
				String comando = entrada.nextLine();
				System.out.println("Comando recebido: " + comando);
				switch (comando) {
				case "c1":
					saida.println("Comando c1 sendo processado!");
					ComandoC1ChamaWS c1Ws = new ComandoC1ChamaWS(saida);
					ComandoC1AcessaBanco c1Banco = new ComandoC1AcessaBanco(saida);
					Future<String> futureWS = threadPool.submit(c1Ws);
					Future<String> futureBanco = threadPool.submit(c1Banco);
					this.threadPool.submit(new JuntaResultadosFutureWSEBanco(futureWS, futureBanco, saida));

					break;
				case "c2":
					saida.println("Comando c2 foi processado!");
					ComandoC2 c2 = new ComandoC2(saida);
					threadPool.execute(c2);
					break;
				case "c3":
					this.filaComando.put(comando);
					saida.println("Comando c3 foi processado!");
					break;
				case "fim":
					saida.println("Desligando o servidor!");
					servidor.parar();
					break;
				default:
					saida.println("Comando "+ comando + ", não encontrado! " );
					break;
				}
			}
			entrada.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
