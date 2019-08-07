package ed.fila;

public class TesteFila {

	public static void main(String[] args) {

		Fila fila = new Fila();

		fila.adiciona("Mauricio");
		fila.adiciona("Guilherme");

		System.out.println(fila);
		
		fila.remove();
		System.out.println(fila);
		fila.remove();
		System.out.println(fila.vazia());
		

	}

}
