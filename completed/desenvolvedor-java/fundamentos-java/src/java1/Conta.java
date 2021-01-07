package java1;
public class Conta {

	int numero;
	int agencia;
	Pessoa titular;
	private double saldo;
	private double limite;
	private static int numeroIncremental = 1;

	public Conta() {
		this.numero = numeroIncremental;
		numeroIncremental++;
	}

	public Conta(int numero, int agencia, double limite, Pessoa titular) {
		this.numero = numero;
		this.agencia = agencia;
		this.limite = limite;
		this.titular = titular;
	}

	void deposita(double valor) {
		this.saldo += valor;
	}

	void saca(double valor) {
		if (this.saldo >= (valor + this.limite)) {
			this.saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente!");
		}

	}

	void tranfere(double valor, Conta destino) {
		if (this.saldo >= valor) {
			destino.saldo += valor;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}

