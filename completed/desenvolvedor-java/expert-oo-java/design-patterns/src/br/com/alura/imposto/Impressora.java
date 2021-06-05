package br.com.alura.imposto;

public class Impressora implements AcaoAposGerarNota {

	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("imprimi nota fiscal");

	}

}
