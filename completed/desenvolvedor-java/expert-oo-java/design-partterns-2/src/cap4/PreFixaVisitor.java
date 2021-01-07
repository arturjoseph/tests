package cap4;

public class PreFixaVisitor implements Visitor {

	@Override
	public void vistaNumero(Numero numero) {
		System.out.print(numero.getNumero());

	}

	@Override
	public void vistaSoma(Soma soma) {
		System.out.print(" + ");
		System.out.print("(");
		soma.getEsquerda().aceita(this);
		soma.getDireita().aceita(this);
		System.out.print(")");

	}

	@Override
	public void vistaSubtracao(Subtracao subtracao) {
		System.out.print(" - ");
		System.out.print("(");
		subtracao.getEsquerda().aceita(this);
		subtracao.getDireita().aceita(this);
		System.out.print(")");

	}

	@Override
	public void vistaMultiplicacao(Multiplicacao multiplicacao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void vistaDivisao(Divisao divisao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void vistaRaizQuadrada(RaizQuadrada raizQuadrada) {
		// TODO Auto-generated method stub

	}
}
