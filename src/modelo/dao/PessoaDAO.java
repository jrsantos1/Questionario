package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.DBFactory;
import modelo.entidades.Pessoa;
import modelo.entidades.Questao;

public class PessoaDAO {
	
	private ArrayList<Pessoa> pessoas  = new ArrayList<>();
	private Connection conexao = new DBFactory().getConexao();
	
	public void cadastrarPessoa(Pessoa pessoa) throws SQLException {
		
		String query = "insert into Usuario values (null, ?,?)";
		
		PreparedStatement ps = conexao.prepareStatement(query);
		
		//ps.setInt(1, pessoa.getId());
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getSenha());
		
		ps.execute();
		//conexao.commit();
		ps.close();
		
	}
	
	public String getPessoa(int id) throws SQLException {
		
		String query = "Select nome from Usuario where id = ?";
		
		PreparedStatement ps = conexao.prepareStatement(query);		
				
		ResultSet resultado = ps.executeQuery();
		
		if(resultado.next())
			return (String) resultado.getString("Nome");
		
		return "Nenhum usuário foi encontrado";
		
		}		
		
	
		public Boolean validaLogin(Pessoa pessoa){
			
		String query = "SELECT * FROM Usuario WHERE nome == ? AND senha == ?";
		
		try {
		
		PreparedStatement ps = conexao.prepareStatement(query); 
		
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getSenha());
		
		ResultSet resultado = ps.executeQuery();
		
		System.out.println(resultado.getFetchSize());
		

		
		if(resultado.next()) {
			return true;
		}else {
			return false;
		}}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
public ArrayList<Pessoa> getPessoas() throws SQLException {
		
		String query = "Select * from Usuario";
		
		PreparedStatement ps = conexao.prepareStatement(query);		
				
		ResultSet resultado = ps.executeQuery();
		
		while(resultado.next()) {
			
			pessoas.add(new Pessoa(
					resultado.getInt("id"),
					resultado.getString("Nome")));
					
		}		
		return pessoas;
		
	}
	
	
	
	

}
