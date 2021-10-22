package br.com.caelum.fj11.modelo;

public class TotalizadorDeBonus{

	private double total = 0;

	public void adiciona(Funcionario funcionario){
		total += funcionario.getBonus();
	}

	public double getTotal(){
		return this.total;
	}
}
