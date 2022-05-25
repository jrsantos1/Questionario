package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBFactory {
	
	public Connection conexao;
	
	public Connection getConexao() {
		//String stringConexao = "jdbc:sqlite:database.db";
		
		try {
			
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url");
			conexao = DriverManager.getConnection(url);
			return conexao;
			
		}catch(SQLException | IOException e ){
			
			throw new RuntimeException(e);
			
		}
	
	}

	
	private static Properties getProperties() throws IOException {
		Properties pro = new Properties();
		String path = "/conexao.properties";
		pro.load(DBFactory.class.getResourceAsStream(path));
		return pro;
	}
	
	public void criarTabela(String query) {
		
		Connection conexao = getConexao();
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(query);
			
			ps.execute();
			ps.close();
			
			
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
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
