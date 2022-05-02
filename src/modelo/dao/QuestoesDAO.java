package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.DBFactory;
import modelo.entidades.Questao;

public class QuestoesDAO {		
	
	private static ArrayList<Questao> result = new ArrayList<>();
	
	private Connection conexao = new DBFactory().getConexao();
	
	public void adicionaQuestao(Questao questao) throws SQLException {
		
		String query = "INSERT INTO Questoes values (?,?,?,?,?,?)";
		
		PreparedStatement ps = conexao.prepareStatement(query);
		
		ps.setString(1, questao.getTitulo());
		ps.setString(2, questao.getAlternativa01());
		ps.setString(3, questao.getAlternativa01());
		ps.setString(4, questao.getAlternativa01());
		ps.setString(5, questao.getAlternativa01());
		ps.setString(6, questao.getAlternativaCorreta());
				
		ps.execute();
		
	}
	
	public ArrayList<Questao> getQuestoes() {
		
		String query = "Select * from Questao";
		
		try {
		PreparedStatement ps = conexao.prepareStatement(query);		
				
		ResultSet resultado = ps.executeQuery();
		
		while(resultado.next()) {
			result.add(new Questao(resultado.getInt("id"),
					resultado.getString("questao"),
					resultado.getString("alternativa01"),
					resultado.getString("alternativa02"),
					resultado.getString("alternativa03"),
					resultado.getString("alternativa04"),
					resultado.getString("alternativaCorreta")));
					
		}	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return result;
		
	}
	
	

}
