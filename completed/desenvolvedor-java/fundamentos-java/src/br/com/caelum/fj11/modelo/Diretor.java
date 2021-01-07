package br.com.caelum.fj11.modelo;

public class Diretor extends Funcionario implements Autenticavel{
	public double getBonus(){
		return this.getSalario() * 0.4;
	}

	@Override
	public boolean autentica(int senha) {
		// TODO Auto-generated method stub
		return false;
	}
}
