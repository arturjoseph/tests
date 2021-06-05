package br.com.alura.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.alura.empresa.modelo.Funcionario;
import br.com.alura.empresa.modelo.Gasto;

public class TestaGasto {

	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1999, 12, 12);
		Funcionario joao = new Funcionario("Jão", 12, dataNascimento);
		
		Calendar hoje = Calendar.getInstance();
		Gasto taxi = new Gasto(40, "taxi", joao, hoje);
		Gasto taxi1 = new Gasto(40, "taxi", joao, hoje);
		Gasto taxi2 = new Gasto(40, "taxi", joao, hoje);
		
		System.out.println(taxi);
		System.out.println(taxi1);
		System.out.println(taxi2);
		
	}
}
