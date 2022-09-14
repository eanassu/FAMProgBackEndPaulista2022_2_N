package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.vemprafam.pojo.Funcionario;

public class DaoFuncionario {

	private Connection connection;
	private String url = "jdbc:hsqldb:hsql://localhost/";
	private String user = "SA";
	private String password = "";
	
	public DaoFuncionario() {
		try { 
			connection = DriverManager.getConnection(url,user,password);
		} catch ( SQLException e ) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getLista() {
		List<Funcionario> lista =  new ArrayList<Funcionario>();
		try { 
			String sql = " SELECT * FROM FUNCIONARIOS";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				lista.add(new Funcionario(rs.getInt(1),
										  rs.getString(2),
										  rs.getDate(3),
										  rs.getDouble(4)));
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return lista;
	}
	
 	public void inserirFuncionario( Funcionario funcionario ) {
 		try {
 			String sql = "INSERT INTO FUNCIONARIOS VALUES(?,?,?,?)";
 			PreparedStatement pstmt = connection.prepareStatement(sql);
 			pstmt.setInt(1, funcionario.getRe());
 			pstmt.setString(2, funcionario.getNome());
 			pstmt.setDate(3, 
 					new Date(funcionario.getDataAdmissao().getTime()));
 			pstmt.setDouble(4, funcionario.getSalario());
 			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
 	}
 	
 	public void excluirFuncionario( Funcionario funcionario ) {
 		try {
 			String sql = "DELETE FROM FUNCIONARIOS WHERE RE=?";
 			PreparedStatement pstmt = connection.prepareStatement(sql);
 			pstmt.setInt(1, funcionario.getRe());
 			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 		
 	}
	
 	public static void main(String[] args) {
 		System.out.println(1.0/0);
 		System.out.println("teste");
 		System.out.println(Math.sqrt(-1));
 		System.out.println(0.0/0);
 		System.out.println(0/0);
	}
}
