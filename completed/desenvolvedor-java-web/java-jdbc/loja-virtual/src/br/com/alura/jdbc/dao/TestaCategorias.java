package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionPoll;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection con = new ConnectionPoll().getConection()) {

			List<Categoria> categorias = new CategoriasDAO(con).listaComProdutos();
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
				for (Produto produto :categoria.getProdutos()) {
					System.out.println(categoria.getNome() +" - "+ produto.getNome());					
				}
			}
		}

	}
}
