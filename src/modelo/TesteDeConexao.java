package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.dao.PessoaDAO;
import modelo.dao.PontuacaoDAO;
import modelo.dao.QuestoesDAO;
import modelo.entidades.Pessoa;
import modelo.entidades.Pontuacao;
import modelo.entidades.Questao;

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
		 * System.out.println("Questão criada com sucesso");
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
		 
		 ArrayList<Questao> qtdao = new QuestoesDAO().getQuestoes();
		 
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
