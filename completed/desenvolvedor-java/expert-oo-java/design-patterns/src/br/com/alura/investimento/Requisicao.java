package br.com.alura.investimento;

enum Formato {
	XML, CSV, PORCENTO
}

public class Requisicao {

	private Formato formato;

	public Requisicao(Formato formato) {
		this.formato = formato;
	}

	public Formato getFormato() {
		return formato;
	}


}
