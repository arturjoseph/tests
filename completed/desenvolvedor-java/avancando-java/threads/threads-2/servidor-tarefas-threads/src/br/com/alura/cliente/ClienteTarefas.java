package br.com.alura.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 12345);
		System.out.println("Conexão estabelecida");

		Thread threadEnviaComando = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					System.out.println("Pode enviar comandos");
					PrintStream saida = new PrintStream(socket.getOutputStream());
					Scanner teclado = new Scanner(System.in);
					while (teclado.hasNextLine()) {
						String linha = teclado.nextLine();
						if (linha.trim().equals("")) {
							break;
						}
						saida.println(linha);
					}
					teclado.close();
					saida.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

		Thread threadRecebeResposta = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Recebendo dados do servidor!");
					Scanner repostaServidor = new Scanner(socket.getInputStream());
					while (repostaServidor.hasNextLine()) {
						String linha = repostaServidor.nextLine();
						System.out.println(linha);
					}
					repostaServidor.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

		threadRecebeResposta.start();
		threadEnviaComando.start();
		
		threadEnviaComando.join();
		
		System.out.println("Fechando conexão com cliente");
		socket.close();
	}

}
