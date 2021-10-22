package cap4;

public interface Visitor {

	void vistaNumero(Numero numero);

	void vistaSoma(Soma soma);

	void vistaSubtracao(Subtracao subtracao);

	void vistaMultiplicacao(Multiplicacao multiplicacao);

	void vistaDivisao(Divisao divisao);
	
	void vistaRaizQuadrada(RaizQuadrada raizQuadrada);

}