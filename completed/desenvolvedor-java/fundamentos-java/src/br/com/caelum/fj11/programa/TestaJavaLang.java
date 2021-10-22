package br.com.caelum.fj11.programa;
import br.com.caelum.fj11.modelo.Conta;
import br.com.caelum.fj11.modelo.GuardadorDeObjetos;

public class TestaJavaLang {
	
	public static void main(String[] args) {

		Conta c1 = new Conta("Artur", 123, 1238, 500);
		Conta c2 = new Conta("Neto", 123, 9872, 500);

		GuardadorDeObjetos armario = new GuardadorDeObjetos();
		armario.adiciona(c1);
		armario.adiciona(c2);

		Conta conta1Armario = (Conta) armario.pega(0);

		System.out.println(conta1Armario);
		
		if (c1.equals(c2)) {
			System.out.println("são iguais");
		}else {
			System.out.println("são diferentes");
		}
		
		String curso = "fj11";
		String cursoAlt = curso.replace("j", "k");
		
		System.out.println(cursoAlt);
	}

}
