package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void deveReceberVariosLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

		assertEquals(2, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);
	}

	@Test
	public void NaoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");

		Usuario jobs = new Usuario("Steve Jobs");

		leilao.propoe(new Lance(jobs, 2000.0));
		leilao.propoe(new Lance(jobs, 3000.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void NaoDeveAceitarMaisDoQueCincoLancesDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");

		Usuario jobs = new Usuario("Steve Jobs");
		Usuario bill = new Usuario("Bill Gates");

		leilao.propoe(new Lance(jobs, 2000.0));
		leilao.propoe(new Lance(bill, 3000.0));
		leilao.propoe(new Lance(jobs, 4000.0));
		leilao.propoe(new Lance(bill, 5000.0));
		leilao.propoe(new Lance(jobs, 6000.0));
		leilao.propoe(new Lance(bill, 7000.0));
		leilao.propoe(new Lance(jobs, 8000.0));
		leilao.propoe(new Lance(bill, 9000.0));
		leilao.propoe(new Lance(jobs, 10000.0));
		leilao.propoe(new Lance(bill, 11000.0));
		// deve ser ignorado
		leilao.propoe(new Lance(jobs, 12000.0));

		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);
	}

	@Test
	public void deveDobrarOUltimoLanceDado() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.dobraLance(steveJobs);

		assertEquals(4000, leilao.getLances().get(2).getValor(), 0.00001);
	}

	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");

		leilao.dobraLance(steveJobs);

		assertEquals(0, leilao.getLances().size());
	}
}
