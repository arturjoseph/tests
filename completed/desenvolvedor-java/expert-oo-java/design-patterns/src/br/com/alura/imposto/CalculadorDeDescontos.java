package br.com.alura.imposto;

public class CalculadorDeDescontos {
	
	public double calcula(Orcamento orcamento){
		Desconto semDesconto = new SemDesconto();
		Desconto cincoItens = new DescontoPorCincoItens();
		Desconto maisQuinhetos = new DescontoPorMaisDeQuinhentosReais();
		Desconto vendaCasada = new DescontoPorVendaCasada();
		
		cincoItens.setProximo(vendaCasada);
		vendaCasada.setProximo(maisQuinhetos);
		maisQuinhetos.setProximo(semDesconto);
		
		return cincoItens.desconta(orcamento);
	}

}
