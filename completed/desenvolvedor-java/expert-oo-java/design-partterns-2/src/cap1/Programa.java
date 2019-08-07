package cap1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Programa {

	public static void main(String[] args) throws SQLException {

		Connection conexao = new ConnectionFactory().getConnection();
		
		PreparedStatement ps = conexao.prepareStatement("select * from tabela");
		System.out.println(ps);

	}

}
