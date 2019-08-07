package br.com.caelum.fj11.programa;

import br.com.caelum.fj11.modelo.Conta;

public class TestaConcorrencia {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		BarraDeProgresso barra = new BarraDeProgresso();
		Thread t1 = new Thread(barra);
		t1.start();
		
		CopiadorDeArquivos copiador = new CopiadorDeArquivos();
		Thread t2 = new Thread(copiador);
		t2.start();*/
		
		Conta c1 = new Conta(500.0);
		FazDeposito acao = new FazDeposito(c1);
		Thread t1 = new Thread(acao);
		Thread t2 = new Thread(acao);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(c1.getSaldo());
		
		
		
	}
	

}
