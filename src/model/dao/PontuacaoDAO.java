package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBFactory;
import model.entidades.Pontuacao;

public class PontuacaoDAO {

	Connection conexao = new DBFactory().getConexao();
	ArrayList<Pontuacao> pontuacoes = new ArrayList<>();
	
	public void adicionaPontuacao( Pontuacao pontuacao) throws SQLException {

		String query = "insert into Pontuacao values (?,?, null)";
		PreparedStatement ps = conexao.prepareStatement(query);

		ps.setInt(1, pontuacao.getPontuacao());
		ps.setInt(2, pontuacao.getId());

		ps.execute();
		ps.close();

	}

	public ArrayList<Pontuacao> getPontuacoes() throws SQLException{
		
		String query = "SELECT Usuario.nome, Pontuacao.pontuacao FROM Usuario INNER JOIN Pontuacao ON Usuario.id == Pontuacao.id";
		
		PreparedStatement ps = conexao.prepareStatement(query);		
		
		ResultSet resultado = ps.executeQuery();
		
		while(resultado.next()) {
			pontuacoes.add(new Pontuacao(resultado.getString("nome"),resultado.getInt("pontuacao")));				
		}
		ps.close();
		resultado.close();
		return pontuacoes;
		
	}
        public ArrayList<Pontuacao> getPontuacoestoP10() throws SQLException{
		
		String query = "SELECT Usuario.nome, Pontuacao.pontuacao FROM Usuario INNER JOIN Pontuacao ON Usuario.id == Pontuacao.id ORDER BY Pontuacao.pontuacao DESC LIMIT 20;";
		
		PreparedStatement ps = conexao.prepareStatement(query);		
		
		ResultSet resultado = ps.executeQuery();
		
		while(resultado.next()) {
			pontuacoes.add(new Pontuacao(resultado.getString("nome"),resultado.getInt("pontuacao")));				
		}
		ps.close();
		resultado.close();
		return pontuacoes;
		
	}
        
        
        
}
