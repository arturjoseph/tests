package br.com.alura.imposto;

public class Finalizado implements EstadoDeUmOrcamento{

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orcamentos finalizados não recebem desconto extra!");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("orçamento já finalizado!");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("orçamento já finalizado!");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("orçamento já finalizado!");
	}

}
