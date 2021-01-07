package br.com.caelum.leilao.servico;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriiadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario maria;
	private Usuario jose;
	private Usuario joao;

	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
	}

	@After
	public void finaliza() {
		System.out.println("fim");
	}

	@BeforeClass
	public static void testandoBeforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
		System.out.println("after class");
	}

	@Test
	public void deveEntenderLancesEmordemDecrescente() {

		Leilao leilao = new CriiadorDeLeilao().para("Playstation 3 novo").lance(joao, 400.0).lance(jose, 300.0)
				.lance(joao, 200.0).lance(maria, 100.0).constroi();

		// parte2: acao
		leiloeiro.avalia(leilao);

		// parte 3: validacao
		double maiorEsperado = 400;
		double menorEsperado = 100;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveEntenderLancesEmordemCrescente() {

		Leilao leilao = new Leilao("Playstation 3 novo");
		leilao.propoe(new Lance(joao, 1000.0));
		leilao.propoe(new Lance(jose, 2000.0));
		leilao.propoe(new Lance(maria, 3000.0));

		// parte2: acao
		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMaiorLance(), equalTo(3000.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(1000.0));

	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

		Leilao leilao = new Leilao("Playstation 3 novo");
		leilao.propoe(new Lance(joao, 1000.0));

		leiloeiro.avalia(leilao);

		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void DeveEncontrarTresMaioresLances() {

		Leilao leilao = new CriiadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100).lance(maria, 200)
				.lance(joao, 300).lance(maria, 400).constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());

		assertThat(maiores, hasItems(new Lance(maria, 400), new Lance(joao, 300), new Lance(maria, 200)));
	}

	@Test
	public void deveEntenderLeilaoComLancesEmOrdemRandomica() {

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(maria, 450.0));
		leilao.propoe(new Lance(joao, 120.0));
		leilao.propoe(new Lance(maria, 700.0));
		leilao.propoe(new Lance(joao, 630.0));
		leilao.propoe(new Lance(maria, 230.0));

		leiloeiro.avalia(leilao);

		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		Leilao leilao = new CriiadorDeLeilao().para("Playstation 3 Novo").constroi();
		leiloeiro.avalia(leilao);
	}

}
