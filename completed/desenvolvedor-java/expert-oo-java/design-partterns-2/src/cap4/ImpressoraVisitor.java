package cap4;

public class ImpressoraVisitor implements Visitor {
	@Override
	public void vistaNumero(Numero num) {
		System.out.print(num.getNumero());
	}

	@Override
	public void vistaSoma(Soma soma) {
		System.out.print("(");

		soma.getEsquerda().aceita(this);
		System.out.print(" + ");

		soma.getDireita().aceita(this);
		System.out.print(")");
	}

	@Override
	public void vistaSubtracao(Subtracao subtracao) {
		System.out.print("(");

		subtracao.getEsquerda().aceita(this);
		System.out.print(" + ");

		subtracao.getDireita().aceita(this);
		System.out.print(")");
	}

	@Override
	public void vistaMultiplicacao(Multiplicacao multiplicacao) {
		System.out.print("(");

		multiplicacao.getEsquerda().aceita(this);
		System.out.print(" + ");

		multiplicacao.getDireita().aceita(this);
		System.out.print(")");
	}

	@Override
	public void vistaDivisao(Divisao divisao) {
		System.out.print("(");

		divisao.getEsquerda().aceita(this);
		System.out.print(" + ");

		divisao.getDireita().aceita(this);
		System.out.print(")");
	}

	@Override
	public void vistaRaizQuadrada(RaizQuadrada raizQuadrada) {
		
		System.out.print("(");
		raizQuadrada.getExpressao().aceita(this);
		System.out.print(")");
		
	}

}
