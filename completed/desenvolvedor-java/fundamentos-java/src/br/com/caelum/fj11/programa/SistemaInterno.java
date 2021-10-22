package br.com.caelum.fj11.programa;

import br.com.caelum.fj11.modelo.Autenticavel;

public class SistemaInterno {

	public void autentica(Autenticavel auth) {
		int senha = 123;
		if(auth.autentica(senha)== true) {
			System.out.println("Bem vindo ao sistema");
		}else {
			System.out.println("senha incorreta");
		}
			
	}
	
}
