package br.com.arturjoseph.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.arturjoseph.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, LocalDate localDate) {
		LocalDate vencimento = localDate.plusDays(7);
		pagto.setDataVencimento(vencimento);
	}

}
