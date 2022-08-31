import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TesteInjecao {

	public static void main(String[] args) {
		try {
			String re = "10;DROP TABLE IMPORTANTE";
			Connection connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/", "SA", "");
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(
				"DELETE from FUNCIONARIOS where re = " + re );
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
