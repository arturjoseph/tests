package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWSEBanco implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureBanco;
	private PrintStream saida;

	public JuntaResultadosFutureWSEBanco(Future<String> futureWS, Future<String> futureBanco, PrintStream saida) {
		this.futureWS = futureWS;
		this.futureBanco = futureBanco;
		this.saida = saida;
	}

	@Override
	public Void call() {

		try {
			String numeroMagico = this.futureWS.get(15, TimeUnit.SECONDS);
			String numeroMagico2 = this.futureBanco.get(15, TimeUnit.SECONDS);
			this.saida.println("Resultado comando c1: " + numeroMagico + ", " + numeroMagico2);

		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Timeout: Cancelando Execução do comando c1 ");
			this.saida.println("Timeout na execução do comando c1");
			this.futureWS.cancel(true);
			this.futureBanco.cancel(true);
		}
		System.out.println("Finalizou JuntaResultadosFutureWSEBanco");
		return null;
	}

}
