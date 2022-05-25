package model.entidades;

import java.util.Objects;

public class Pontuacao {
	
	private int id;
	private String nome;
	private int pontuacao;
	
	public Pontuacao(int id, int pontuacao) {
		super();
		this.id = id;
		this.pontuacao = pontuacao;
	}
	
	public Pontuacao(String nome, int pontuacao) {
		super();
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, pontuacao);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pontuacao other = (Pontuacao) obj;
		return Objects.equals(id, other.id) && pontuacao == other.pontuacao;
	}
	
}
