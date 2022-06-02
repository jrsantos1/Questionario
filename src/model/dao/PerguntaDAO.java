package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DBFactory;
import model.entidades.Pergunta;

public class PerguntaDAO {

	private static ArrayList<Pergunta> result = new ArrayList<>();

	private static String[][] result2;

	private Connection conexao = new DBFactory().getConexao();

	public void adicionaQuestao(Pergunta questao) throws SQLException {

		String query = "INSERT INTO Questoes values (?,?,?,?,?,?)";

		PreparedStatement ps = conexao.prepareStatement(query);

		ps.setString(1, questao.getTitulo());
		ps.setString(2, questao.getAlternativa01());
		ps.setString(3, questao.getAlternativa01());
		ps.setString(4, questao.getAlternativa01());
		ps.setString(5, questao.getAlternativa01());
		ps.setString(6, questao.getAlternativaCorreta());

		ps.execute();
		ps.close();

	}

	public ArrayList<Pergunta> getQuestoes() throws SQLException {

		String query = "Select * from Questao";

		try {
			PreparedStatement ps = conexao.prepareStatement(query);

			ResultSet resultado = ps.executeQuery();

			int inicial = 0;

			while (resultado.next()) {
								  
				  result.add(new Pergunta(resultado.getInt("id"),
				  resultado.getString("questao"), resultado.getString("alternativa01"),
				  resultado.getString("alternativa02"), resultado.getString("alternativa03"),
				  resultado.getString("alternativa04"),
				  resultado.getString("alternativaCorreta")));
				  				 

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			conexao.close();
		}
		return result;

	}

	public ArrayList<Pergunta> getQuestoesArray() throws SQLException {

		String query = "Select * from Questao";

		result2 = new String[10][6];

		try {
			PreparedStatement ps = conexao.prepareStatement(query);

			ResultSet resultado = ps.executeQuery();

			while (resultado.next()) {
				
				
				
				/*
				 * result.add(new Pergunta(resultado.getInt("id"),
				 * resultado.getString("questao"), resultado.getString("alternativa01"),
				 * resultado.getString("alternativa02"), resultado.getString("alternativa03"),
				 * resultado.getString("alternativa04"),
				 * resultado.getString("alternativaCorreta")));
				 */
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			conexao.close();
		}
		return result;

	}

}
