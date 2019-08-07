package br.com.caelum.fj11.modelo;

public class DBA extends Funcionario {
	public double getBonus() {
		return this.getSalario() * 0.25;
	}
}
