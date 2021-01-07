package br.com.alura;

public class TestaBuscaAlunosNoCurso {
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
		
		System.out.println("Quem é o aluno com matricula 1278?");
		Aluno aluno = javaColecoes.buscaMatriculado(1278);
		System.out.println("Aluno: "+aluno);
	}

}
