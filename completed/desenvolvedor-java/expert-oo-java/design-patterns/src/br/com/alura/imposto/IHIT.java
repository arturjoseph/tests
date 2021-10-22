package br.com.alura.imposto;

import java.util.ArrayList;
import java.util.List;

public class IHIT extends TemplateDeImpostosCondicional {

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * (0.01 * orcamento.getItens().size());
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return (orcamento.getValor() * 0.13) + 100.0;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return existe2ItensIguaiNo(orcamento);
	}

	private boolean existe2ItensIguaiNo(Orcamento orcamento) {
		List<String> noOrcamento = new ArrayList<String>();
		for (Item item : orcamento.getItens()) {
			if (noOrcamento.contains(item.getNome())) {
				return true;
			} else {
				noOrcamento.add(item.getNome());
			}
		}
		return false;
	}
}
