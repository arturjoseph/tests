package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.rh.ValidacaoException;

public class ReajusteService {
	
	public void reajustarSalarioDo(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal percentualReajuste = aumento.divide(funcionario.getSalario(), RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		funcionario.atualizaSalario(funcionario.getSalario().add(aumento));
	}

}
