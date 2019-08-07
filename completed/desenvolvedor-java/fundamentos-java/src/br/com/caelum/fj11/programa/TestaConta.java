package br.com.caelum.fj11.programa;

import br.com.caelum.fj11.excecao.SaldoInsuficienteException;
import br.com.caelum.fj11.modelo.Conta;


public class TestaConta {

	public static void main(String[] args) {
		Conta conta = new Conta("Mauricio", 123, 123-2,50.0);
		try {
			conta.saca(60.0);
		} catch (SaldoInsuficienteException e) {
			System.out.println( "Saldo está insuficiente: "+e.getSaldoAtual());
		}
		 catch (Exception e) {
				System.out.println("um outro erro: " + e);
			}

		conta.imprime();

	}
}
