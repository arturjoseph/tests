package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC1AcessaBanco implements Callable<String> {

	private PrintStream saida;

	public ComandoC1AcessaBanco(PrintStream saida) {
		this.saida = saida;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Servidor recebeu comando c1 - Banco");
		saida.println("Processando comando c1 - Banco");
		Thread.sleep(15000);
		int numero = new Random().nextInt(100)+1;
		
		System.out.println("Servidor finalizou comando c1 - Banco!");

		return Integer.toString(numero);
	}

}
