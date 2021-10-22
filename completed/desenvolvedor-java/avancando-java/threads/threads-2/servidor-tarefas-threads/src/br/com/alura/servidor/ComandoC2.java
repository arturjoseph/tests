package br.com.alura.servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

	private PrintStream saida;

	public ComandoC2(PrintStream saida) {
		this.saida = saida;
	}

	@Override
	public void run() {
		System.out.println("Execuntando comando c2");
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		saida.println("Comando c2 Executado com sucesso!");
	}

}
