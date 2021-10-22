package br.com.caelum.fj11.programa;

public class BarraDeProgresso implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("barra de progresso");
		}
		
	}

}
