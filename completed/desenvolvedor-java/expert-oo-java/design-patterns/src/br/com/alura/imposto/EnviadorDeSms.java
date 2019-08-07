package br.com.alura.imposto;

public class EnviadorDeSms implements AcaoAposGerarNota{
	
	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Nota fiscal envida por sms");
		
	}

}
