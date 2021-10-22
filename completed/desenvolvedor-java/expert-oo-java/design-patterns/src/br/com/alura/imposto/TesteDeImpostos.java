package br.com.alura.imposto;

public class TesteDeImpostos {

	public static void main(String[] args) {

		//Imposto iss = new Iss();
		Imposto icms = new ICMS();
		Imposto iccc = new ICCC();

		Orcamento orcamento = new Orcamento(4000.00);
		CalculadorDeImposto calculador = new CalculadorDeImposto();

		//calculador.realizaCalculo(orcamento, iss);
		calculador.realizaCalculo(orcamento, icms);
		calculador.realizaCalculo(orcamento, iccc);

	}

}
