package cap2;

import java.util.List;

public class GeradorDeNotaFiscal {

	private List<AcaoAposGerarNota> todasAcoesASeremExecutadas;

	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> todasAcoesASeremExecutadas) {
		this.todasAcoesASeremExecutadas = todasAcoesASeremExecutadas;
	}

	public NotaFiscal gera(Fatura fatura) {

		double valor = fatura.getValorMensal();

		NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobreO(valor));

		for (AcaoAposGerarNota acao : todasAcoesASeremExecutadas) {
			acao.executa(nf);
		}

		return nf;
	}

	private double impostoSimplesSobreO(double valor) {
		return valor * 0.06;
	}
}
