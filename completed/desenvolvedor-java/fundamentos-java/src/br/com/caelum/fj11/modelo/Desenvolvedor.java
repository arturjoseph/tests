package br.com.caelum.fj11.modelo;

public class Desenvolvedor extends Funcionario{
	public double getBonus(){
		return this.getSalario() * 0.25;
	}
}
