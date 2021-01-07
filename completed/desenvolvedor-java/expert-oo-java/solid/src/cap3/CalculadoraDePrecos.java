package cap3;

public class CalculadoraDePrecos {

	private TabelaDePreco tabela;
	private ServicoDeEntrega entrega;

	public CalculadoraDePrecos(TabelaDePreco tabela, ServicoDeEntrega entrega) {
		this.tabela = new TabelaDePrecoPadrao();
		this.entrega = new Frete();
	}
	
    public double calcula(Compra produto) {

        double desconto = tabela.descontoPara(produto.getValor());
        double frete = entrega.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }
}

