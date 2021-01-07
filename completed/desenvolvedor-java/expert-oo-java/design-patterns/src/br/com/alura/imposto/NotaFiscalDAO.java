package br.com.alura.imposto;

public class NotaFiscalDAO implements AcaoAposGerarNota{
	
	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Nota fiscal salva no banco");
		
	}

}
