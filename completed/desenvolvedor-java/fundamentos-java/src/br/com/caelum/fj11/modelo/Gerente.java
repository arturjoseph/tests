package br.com.caelum.fj11.modelo;

public class Gerente extends Funcionario implements Autenticavel{
	public double getBonus(){
		return this.getSalario() * 0.3;
	}
	
	public void cobrarRelatórios() {
		System.out.println("Preciso dos relatórios");
	}

	@Override
	public boolean autentica(int senha) {
		// TODO Auto-generated method stub
		return false;
	}
}
