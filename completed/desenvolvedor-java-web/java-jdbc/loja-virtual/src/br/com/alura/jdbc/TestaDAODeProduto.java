package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutosDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaDAODeProduto {

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto("Mesa vermelhar", "Mesa com 4 pés");

		try (Connection con = new ConnectionPoll().getConection()) {

			ProdutosDAO dao = new ProdutosDAO(con);
			dao.salva(mesa);
			List<Produto> produtos = dao.lista();
			for (Produto produto : produtos) {
				System.out.println("Existe o produto" + produto);
			}
		}
		
	}

}
