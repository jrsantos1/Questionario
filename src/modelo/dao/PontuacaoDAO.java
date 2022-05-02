package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import modelo.DBFactory;
import modelo.entidades.Pontuacao;
import modelo.entidades.Questao;

public class PontuacaoDAO {
	
	Connection conexao = new DBFactory().getConexao();
	ArrayList<Pontuacao> pontuacoes = new ArrayList<>();
	
	public void adicionaPontuacao(Pontuacao pontuacao) throws SQLException {
		
		String query = "insert into Pontuacao values (?,?)";
		
		PreparedStatement ps = conexao.prepareStatement(query);
		
		ps.setInt(1, pontuacao.getId());
		ps.setInt(2, pontuacao.getPontuacao());
		
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
		
		return pontuacoes;
		
	}

}
