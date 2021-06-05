package br.com.alura.empresa.leitor;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;

import br.com.alura.empresa.modelo.Gasto;

public class ImportadorDeGastosTest {

	@Test
	public void deveRetornarListaVaziaSeOArquivopassadoForVazio() throws ParseException {

		ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
		ImportadorDeGastos importadorDeGastos = new ImportadorDeGastos();
		Collection<Gasto> gastos = importadorDeGastos.importa(inputStream);

		assertTrue("A lista não está vazia!", gastos.isEmpty());
	}

	@Test
	public void deveRetornarUmGastoDeUmArquivoNoFormatoCorreto() throws ParseException {

		String conteudo = "CARTAO01012011000010000123Jose da Silva                 22071983\r\n";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(conteudo.getBytes());

		ImportadorDeGastos importadorDeGastos = new ImportadorDeGastos();
		Collection<Gasto> gastos = importadorDeGastos.importa(inputStream);

		assertEquals("Deveria conter um elemento!",1, gastos.size());
		
	}

}
