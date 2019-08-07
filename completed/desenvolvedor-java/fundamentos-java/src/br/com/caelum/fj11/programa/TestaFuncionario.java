package br.com.caelum.fj11.programa;

import br.com.caelum.fj11.modelo.Gerente;
import br.com.caelum.fj11.modelo.TotalizadorDeBonus;

public class TestaFuncionario {
	public static void main(String[] args) {
		
		Gerente joaquim = new Gerente();
		joaquim.setSalario(2000.0);

		System.out.println(joaquim.getBonus());

		TotalizadorDeBonus totalizador = new TotalizadorDeBonus();
		totalizador.adiciona(joaquim);

		System.out.println(totalizador.getTotal());
	}
}
