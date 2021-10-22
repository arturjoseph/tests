package br.com.alura.imposto;

public class Reprovado implements EstadoDeUmOrcamento{

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orcamentos reprovados não recebm desconto extra!");
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("orçamentos reprovados não podem ser aprovados");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("orçamentos já está reprovado!");
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
		
	}

}
