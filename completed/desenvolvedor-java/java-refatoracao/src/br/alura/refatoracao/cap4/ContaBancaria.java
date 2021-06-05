package br.alura.refatoracao.cap4;

public class ContaBancaria {

	protected String titular;
	protected double saldo;

	public ContaBancaria(String titular, double saldoInicial) {
		this.titular = titular;
		this.saldo = saldoInicial;
	}
	
	public void saca(double valor) {
        saldo -= valor;
    }

    public void deposita(double valor) {
        saldo += valor;
    }

	public double getSaldo() {
		return saldo;
	}

	public String getTitular() {
		return titular;
	}
}
