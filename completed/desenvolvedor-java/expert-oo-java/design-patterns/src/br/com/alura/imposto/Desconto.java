package br.com.alura.imposto;

public interface Desconto {
	
	double desconta(Orcamento orcamento);
	void setProximo(Desconto desconto);

}
