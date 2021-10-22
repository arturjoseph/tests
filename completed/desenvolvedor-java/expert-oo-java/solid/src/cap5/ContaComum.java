package cap5;

public class ContaComum {

	private ManipuladorDeSaldo manipulador;

	public ContaComum() {
		this.manipulador = new ManipuladorDeSaldo();
	}

	public void deposita(double valor) {
		manipulador.deposita(valor);
	}

	public double getSaldo() {
		return manipulador.getSaldo();
	}

	public void rende() {
		this.manipulador.rende(1.1);
	}
}
