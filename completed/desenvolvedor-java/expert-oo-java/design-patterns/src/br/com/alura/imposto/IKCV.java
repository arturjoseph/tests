package br.com.alura.imposto;

public class IKCV extends TemplateDeImpostosCondicional {

	 public IKCV() {}

     public IKCV(Imposto outroImposto) {
         super(outroImposto);
     }
     
	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if(item.getValor() > 100) return true;
		}
		return false;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento);
	}

}
