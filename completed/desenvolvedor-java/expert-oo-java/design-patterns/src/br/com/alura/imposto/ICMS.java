package br.com.alura.imposto;

public class ICMS extends Imposto {
	
	public ICMS() {
	}

	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return (orcamento.getValor() * 0.05) + 50.0  + calculoDoOutroImposto(orcamento);
	}
}
