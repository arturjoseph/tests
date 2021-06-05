package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

public class ConnectionPoll {

	private DataSource dataSource;

	public ConnectionPoll() {
		JDBCPool poll = new JDBCPool();
		poll.setUrl("jdbc:hsqldb:hsql://localhost/loja-virtual");
		poll.setUser("SA");
		poll.setPassword("");
		this.dataSource = poll;

	}

	public Connection getConection() throws SQLException {
		// Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		Connection connection = dataSource.getConnection();
		return connection;
	}

}
