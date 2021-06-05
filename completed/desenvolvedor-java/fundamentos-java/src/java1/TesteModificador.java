package java1;

class TesteModificador{

	public static void main(String[] args){
		
		Pessoa titular = new Pessoa("Artur Neto","123123123","17/09/1987");
	
		Conta artur = new Conta(123,842,100.0, titular);

		System.out.println(artur.titular.nome);
		artur.deposita(550.0);
		artur.saca(650.0);
		System.out.println(artur.getSaldo());

		Conta joao = new Conta();
		System.out.println(joao.numero);
		Conta jose = new Conta();
		System.out.println(jose.numero);

	}

}
