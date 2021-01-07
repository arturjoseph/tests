package br.com.alura.empresa.dao;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.alura.empresa.modelo.Gasto;

public class GastoDAO {

	private DAO<Gasto> dao = new DAO<>(Gasto.class);

	private static final Logger logger = Logger.getLogger(GastoDAO.class);

	public void adiciona(Gasto entity) {
		dao.adiciona(entity);
	}

	public void remove(Gasto entity) {
		dao.remove(entity);
		logger.info("Gasto removido com sucesso!");
	}

	public Gasto buscaPorId(Long id) {
		return dao.buscaPorId(id);
	}

	public List<Gasto> buscaTodos() {
		return dao.buscaTodos();
	}

}