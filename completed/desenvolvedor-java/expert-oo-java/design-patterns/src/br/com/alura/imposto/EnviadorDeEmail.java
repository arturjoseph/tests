package br.com.alura.imposto;

public class EnviadorDeEmail implements AcaoAposGerarNota {
	
	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Nota fiscal enviada por email");
	}

}
