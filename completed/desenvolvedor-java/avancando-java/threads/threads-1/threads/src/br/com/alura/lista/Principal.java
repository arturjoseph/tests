package br.com.alura.lista;

public class Principal {

	public static void main(String[] args) {

		//List<String> lista = Collections.synchronizedList(new ArrayList<>());
		//List<String> lista = new Vector<>();
		
		Lista lista = new Lista();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(new TarefaImprimir(lista)).start();
		
		
	}

}
