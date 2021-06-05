package br.com.caelum.fj11.programa;

import java.util.ArrayList;
import java.util.Collections;

import br.com.caelum.fj11.modelo.Conta;

public class TestaColecoes {
	
	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Mauricio");
		nomes.add("Guilherme");
				
		Collections.sort(nomes);
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		
		
		ArrayList<Conta> contas = new ArrayList<>();
		
		Conta c1 = new Conta("Artur", 123, 1234, 500.0);
		Conta c2 = new Conta("Neto", 123, 1234, 500.0);
		
		contas.add(c1);
		contas.add(c2);
		
		for (Conta conta : contas) {
			System.out.println(conta);
		}
		
		
		
		
		
	}

}
