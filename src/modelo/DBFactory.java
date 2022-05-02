package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBFactory {
	
	public Connection conexao;
	
	public Connection getConexao() {
		
		String stringConexao = "jdbc:sqlite:database.db";
		
		try {
			
			conexao = DriverManager.getConnection(stringConexao);
			return conexao;
			
		}catch(SQLException e){
			
			throw new RuntimeException(e);
			
		}
	
	}
	
	public void criarTabela(String query) {
		
		Connection conexao = getConexao();
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(query);
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void excluirTabela(String nomeBanco) {
		
		Connection conexao = getConexao();
		
		try {
			
			String deletar = "drop table " + nomeBanco;
			
			PreparedStatement ps = conexao.prepareStatement(deletar);
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
