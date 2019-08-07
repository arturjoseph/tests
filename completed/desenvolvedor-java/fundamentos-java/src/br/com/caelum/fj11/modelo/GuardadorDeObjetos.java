package br.com.caelum.fj11.modelo;
public class GuardadorDeObjetos {

	private Object[] objetos;
	private int posicaoLivre;

	public GuardadorDeObjetos() {
		this.objetos = new Conta[100];
		this.posicaoLivre = 0;
	}

	public void adiciona(Object objeto) {
		objetos[posicaoLivre] = objeto;
		posicaoLivre++;
	}

	public Object pega(int posicao) {
		return objetos[posicao];
	}
}
