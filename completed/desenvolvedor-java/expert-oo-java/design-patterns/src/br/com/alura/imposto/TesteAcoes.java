package br.com.alura.imposto;

import java.util.ArrayList;
import java.util.List;

public class TesteAcoes {

	public static void main(String[] args) {

		List<AcaoAposGerarNota> acoes = new ArrayList<>();
		acoes.add(new EnviadorDeEmail());
		acoes.add(new NotaFiscalDAO());
		acoes.add(new EnviadorDeSms());
		acoes.add(new Impressora());
		acoes.add(new Multiplicador(5.5));

		NotaFiscalBuilder builder = new NotaFiscalBuilder(acoes);

		NotaFiscal nf = builder.paraEmpresa("Caelum").comCnpj("123.456.789/0001-10")
				.com(new ItemDaNota("item 1", 100.0)).com(new ItemDaNota("item 2", 200.0))
				.com(new ItemDaNota("item 3", 300.0)).comObservacoes("entregar notaFiscal pessoalmente").constroi();

		System.out.println(nf.getValorBruto());

	}

}
