package cap5;

public class ContaDeEstudante extends ContaComum {
	private ManipuladorDeSaldo manipulador;
	private int milhas;

	public ContaDeEstudante()  { 
		manipulador = new ManipuladorDeSaldo();
    }

	public void deposita(double valor) {
		manipulador.deposita(valor);
		this.milhas += (int) valor;
	}

	public int getMilhas()  {
        return this.milhas;
    }
	
	public double getSaldo()  {
        return manipulador.getSaldo();
    }
}
