package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriasDAO {

	private Connection con;

	public CategoriasDAO(Connection con) {
		this.con = con;

	}

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select * from Categoria";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					Categoria categoria = new Categoria(id, nome);
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listaComProdutos() throws SQLException {
		
		List<Categoria> categorias = new ArrayList<>();
		Categoria ultima = null;
		String sql = "select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as p_descricao from Categoria as c join Produto as p on p.categoria_id = c.id";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("c_id");
					String nome = rs.getString("c_nome");
					if(ultima==null || !ultima.getNome().equals(nome)) {
						Categoria categoria = new Categoria(id, nome);
						categorias.add(categoria);
						ultima = categoria;
					}
					int idProduto = rs.getInt("p_id");
					String nomeProduto = rs.getString("p_nome");
					String descricaoProduto = rs.getString("p_descricao");
					Produto produto = new Produto(nomeProduto, descricaoProduto);
					produto.setId(idProduto);
					ultima.adiciona(produto);
				}
			}
		}
		return categorias;
	}

}
