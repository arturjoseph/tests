package ed.pilha;

public class TestePilha {

	public static void main(String[] args) {

		Pilha pilha = new Pilha();

		pilha.insere("Mauricio");
		System.out.println(pilha);
		pilha.insere("Guilherme");
		System.out.println(pilha);

		pilha.remove();
		System.out.println(pilha);
		System.out.println(pilha.vazia());
		pilha.remove();
		System.out.println(pilha);
		System.out.println(pilha.vazia());

	}

}
