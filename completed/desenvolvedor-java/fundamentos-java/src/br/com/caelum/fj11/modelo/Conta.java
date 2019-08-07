package br.com.caelum.fj11.modelo;

import br.com.caelum.fj11.excecao.SaldoInsuficienteException;

public class Conta implements Comparable<Conta> {

	private double saldo;
	private String titular;
	private int agencia;
	private int numero;

	public Conta(String titular, int agencia, int numero, double saldo) {
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void imprime() {
		System.out.println("Cliente: " + titular);
		System.out.println("Agencia: " + agencia);
		System.out.println("Conta: " + numero);
		System.out.println("Saldo: " + saldo);

	}

	/**
	 * Realiza um saque na conta dado o valor passado
	 * 
	 * @param valor
	 *            valor a ser sacado
	 * @throws Exception
	 *             caso o saldo seja insuficiente
	 */
	public void saca(double valor) throws Exception {
		if (saldo >= valor) {
			this.saldo -= valor;
		} else {
			throw new SaldoInsuficienteException(saldo);
		}

	}

	/**
	 * Realiza deoisito na conta dado o valor passado
	 * 
	 * @param valor
	 *            valor a ser depositado
	 */
	public synchronized void deposita(double valor) {
		this.saldo += valor;
	}

	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", titular=" + titular + ", agencia=" + agencia + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + numero;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia != other.agencia)
			return false;
		if (numero != other.numero)
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}

	@Override
	public int compareTo(Conta o) {
		if (this.saldo < o.saldo)
			return -1;
		if (this.saldo > o.saldo)
			return 1;
		return 0;
	}

}
