package br.com.alura.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.alura.empresa.modelo.Funcionario;

public class Principal {

	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1985, 3, 18);
		Funcionario maria = new Funcionario("Maria", 123456, dataNascimento);
		
		System.out.println(maria);
	}
	
}
