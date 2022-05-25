package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.PontuacaoDAO;
import model.dao.PerguntaDAO;
import model.entidades.Pontuacao;
import model.entidades.Pergunta;

public class TesteDeConexao {
	public static void main(String[] args) throws SQLException {
		
		/*
		 * Connection conexao = new DBFactory().getConexao();
		 * 
		 * String query =
		 * "insert into Questao values (1,'teste','teste','teste','teste','teste','teste')"
		 * ;
		 * 
		 * Statement st = conexao.createStatement();
		 * 
		 * st.execute(query);
		 * 
		 * System.out.println("Quest�o criada com sucesso");
		 * 
		 * 
		 * 
		 * ArrayList<Questao> qtdao = new QuestoesDAO().getQuestoes();
		 * 
		 * qtdao.stream().forEach(n -> System.out.println(n.getId()))
		 */;
		
		 // Criar Tabelas
		 
			/*
			 * DBFactory db = new DBFactory(); Pessoa pessoa1 = new Pessoa("Pedro","123");
			 * PessoaDAO pessoaDao = new PessoaDAO(); pessoaDao.cadastrarPessoa(pessoa1);
			 */
		
		 //db.criarTabela("create table Pessoa (id INTEGER PRIMARY KEY, Nome text, senha text)");
		 
		//db.excluirTabela("Pessoa");
		
		/*
		 * PessoaDAO pessoadao = new PessoaDAO(); pessoadao.getPessoas();
		 */
		 
		/*
		 * Pessoa pessoa = new Pessoa("Jhonatan", "1223");
		 * 
		 * PessoaDAO pessoaDao = new PessoaDAO(); pessoaDao.validaLogin(pessoa);
		 */
		 
		 ArrayList<Pergunta> qtdao = new PerguntaDAO().getQuestoes();
		 
		 System.out.println(qtdao.size());
		 
		 
		 System.out.println(qtdao.get(0).getAlternativa01());
		  
		  qtdao.stream().forEach(n -> System.out.println(n.getId() + " " + n.getAlternativa01()));
		 
		 PontuacaoDAO pt = new PontuacaoDAO();
		 ArrayList<Pontuacao> listpt =  pt.getPontuacoes();
		 
		 for(Pontuacao novaLista: listpt) {
			 System.out.println(novaLista.getNome());
			 System.out.println(novaLista.getPontuacao());
		 }
		
		 
	
	}

}
