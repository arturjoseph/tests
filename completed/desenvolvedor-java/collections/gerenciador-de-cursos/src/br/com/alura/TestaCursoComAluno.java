package br.com.alura;

public class TestaCursoComAluno {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando classe Aula", 20));
		javaColecoes.adiciona(new Aula("Relacionamentos com coleções", 22));

		Aluno a1 = new Aluno("Rodrigo", 1234);
		Aluno a2 = new Aluno("Guilherme", 1278);
		Aluno a3 = new Aluno("Mauricio", 12456);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Todos os alunos matriculados");
		javaColecoes.getAlunos().forEach(a -> {
			System.out.println(a);
		});

		
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno rodrigo = new Aluno("Rodrigo", 1234);
		System.out.println("E esse rodrigo, está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(rodrigo));
		
		System.out.println("O a1 equals ao rogrigo");
		System.out.println(a1.equals(rodrigo));
		
		
	}

}
