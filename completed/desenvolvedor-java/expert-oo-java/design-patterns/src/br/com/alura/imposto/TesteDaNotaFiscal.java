package br.com.alura.imposto;

public class TesteDaNotaFiscal {

	public static void main(String[] args) {

		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.paraEmpresa("Caelum Ensiona e Inovação")
			   .comCnpj("cnpj")
			   .com(new ItemDaNota("item 1", 200.0)).com(new ItemDaNota("item 2", 300.0)).com(new ItemDaNota("item 3", 400.0))
			   .comObservacoes("qualquer");

		NotaFiscal nf = builder.constroi();

		System.out.println(nf.getValorBruto());

	}

}
