package br.com.alura.investimento;

import java.util.Calendar;

public class Conta {

	protected double saldo;
	private String titular;
	private int agencia;
	private int numero;
	private Calendar dataAbertura;
	public EstadoDaConta estado;

	public Conta() {
		estado = new Positivo();
	}

	public Conta(String titular, int agencia, int numero, double saldo, Calendar dataAbertura) {
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;

	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getTitular() {
		return titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void saca(double valor) {
		estado.saca(this, valor);
	}

	public void deposita(double valor) {
		estado.deposita(this, valor);
	}

}