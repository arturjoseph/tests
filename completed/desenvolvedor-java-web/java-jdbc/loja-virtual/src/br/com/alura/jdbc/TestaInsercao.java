package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionPoll().getConection();) {
			connection.setAutoCommit(false);
			String sql = "insert into Produto (nome, descricao) values(?,?)";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

				adiciona("TV LCD", "32 polegadas", prepareStatement);
				adiciona("Blueray", "Full HDMI", prepareStatement);
				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Rollback efetuado!");
			}
		}

	}

	private static void adiciona(String nome, String descricao, PreparedStatement prepareStatement)
			throws SQLException {

		if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema Ocorrido");
		}

		prepareStatement.setString(1, nome);
		prepareStatement.setString(2, descricao);

		boolean resultado = prepareStatement.execute();
		System.out.println(resultado);

		ResultSet resultSet = prepareStatement.getGeneratedKeys();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			System.out.println(id);
		}
		resultSet.close();
	}
}
