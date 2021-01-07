package ed.vetor;

public class VetorTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("João");
		Aluno a2 = new Aluno("José");

		Vetor lista = new Vetor();
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		System.out.println(lista);
		System.out.println(lista.tamanho());
		
		System.out.println(lista.contem(a1));
		Aluno a3 = new Aluno("Maria");
		System.out.println(lista.contem(a3));
				
		lista.adiciona(1, a3);
		System.out.println(lista);
		
		lista.remove(1);
		System.out.println(lista);
		
		
	}

}
