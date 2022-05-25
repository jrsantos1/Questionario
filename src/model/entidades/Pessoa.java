package model.entidades;

public class Pessoa {
	
	private int id;
	private String nome; 
	private String senha;
	
	
	public Pessoa(int id, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
	
	public Pessoa(String nome, String senha) {
		super();
		this.senha = senha;
		this.nome = nome;
	}
	
	public Pessoa( int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
