import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/", "SA", "");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FUNCIONARIOS");
			while( rs.next() ) {
				int re = rs.getInt("re");
				String nome = rs.getString(2);
				Date dataAdmissao = rs.getDate(3);
				Double salario = rs.getDouble("salario");
				System.out.println(re + " " + nome + " " + dataAdmissao +
						" " + salario);
			}
			stmt.executeUpdate("DELETE FROM FUNCIONARIOS WHERE RE=5");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
