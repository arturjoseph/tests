package br.com.alura.imposto;

public abstract class TemplateDeImpostosCondicional extends Imposto {

	public TemplateDeImpostosCondicional() {
	}

	public TemplateDeImpostosCondicional(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public final double calcula(Orcamento orcamento) {
		if(deveUsarMaximaTaxacao(orcamento)){
			return maximaTaxacao(orcamento) + calculoDoOutroImposto(orcamento);
		}else{
			return minimaTaxacao(orcamento) + calculoDoOutroImposto(orcamento);
		}
		
	}

	public abstract double minimaTaxacao(Orcamento orcamento) ;

	protected abstract double maximaTaxacao(Orcamento orcamento);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

}
