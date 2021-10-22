package br.com.alura.imposto;
public class TesteDeImpostosComplexos {

	public static void main(String[] args) {
		
		Imposto impostoAlto = new ImpostoMuitoAlto(new ICMS());
		Orcamento orcamento = new Orcamento(500);
		
		double valor = impostoAlto.calcula(orcamento);
		
		System.out.println(valor);

	}

}
