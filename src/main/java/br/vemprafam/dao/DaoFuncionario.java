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
			String sql = "SELECT * FROM FUNCIONARIOS";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				lista.add(new Funcionario(rs.getInt(1),
										  rs.getString(2),
										  rs.getDate(3),
										  rs.getDouble(4),
										  rs.getString(5)));
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return lista;
	}
	
 	public void inserirFuncionario( Funcionario funcionario ) {
 		try {
 			String sql = "INSERT INTO FUNCIONARIOS VALUES(?,?,?,?,?)";
 			PreparedStatement pstmt = connection.prepareStatement(sql);
 			pstmt.setInt(1, funcionario.getRe());
 			pstmt.setString(2, funcionario.getNome());
 			pstmt.setDate(3, 
 					new Date(funcionario.getDataAdmissao().getTime()));
 			pstmt.setDouble(4, funcionario.getSalario());
 			pstmt.setString(5, funcionario.getEmail());
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
	
 	public Funcionario buscarPeloRe( int re ) {
 		try {
 			String sql = "SELECT * FROM FUNCIONARIOS WHERE RE=?";
 			PreparedStatement pstmt = connection.prepareStatement(sql);
 			pstmt.setInt( 1, re );
 			ResultSet rs = pstmt.executeQuery();
 			if ( rs.next() ) {
 				return new Funcionario( rs.getInt(1),
 										rs.getString(2),
 										rs.getDate(3),
 										rs.getDouble(4),
 										rs.getString(5));	
 			} else {
 				return null;
 			}
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

	public void alterarFuncionario(Funcionario funcionario) {
 		try {
 			String sql = "UPDATE FUNCIONARIOS SET NOME=?,DATAADMISSAO=?,"
 					+ "SALARIO=?,EMAIL=? WHERE RE=?";
 			PreparedStatement pstmt = connection.prepareStatement(sql);

 			pstmt.setString(1, funcionario.getNome());
 			pstmt.setDate(2, 
 					new Date(funcionario.getDataAdmissao().getTime()));
 			pstmt.setDouble(3, funcionario.getSalario());
 			pstmt.setString(4, funcionario.getEmail());
 			pstmt.setInt(5, funcionario.getRe());
 			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
		
	}
}
