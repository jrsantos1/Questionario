package model.entidades;

public class Pergunta {
	
	private String titulo;
	private String alternativa01;
	private String alternativa02;
	private String alternativa03;
	private String alternativa04;
	private String alternativaCorreta;
	private int id;
	

	public Pergunta(int id, String titulo, String alternativa01, String alternativa02, String alternativa03,
					String alternativa04, String alternativaCorreta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.alternativa01 = alternativa01;
		this.alternativa02 = alternativa02;
		this.alternativa03 = alternativa03;
		this.alternativa04 = alternativa04;
		this.alternativaCorreta = alternativaCorreta;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAlternativa01() {
		return alternativa01;
	}
	public void setAlternativa01(String alternativa01) {
		this.alternativa01 = alternativa01;
	}
	public String getAlternativa02() {
		return alternativa02;
	}
	public void setAlternativa02(String alternativa02) {
		this.alternativa02 = alternativa02;
	}
	public String getAlternativa03() {
		return alternativa03;
	}
	public void setAlternativa03(String alternativa03) {
		this.alternativa03 = alternativa03;
	}
	public String getAlternativa04() {
		return alternativa04;
	}
	public void setAlternativa04(String alternativa04) {
		this.alternativa04 = alternativa04;
	}
	public String getAlternativaCorreta() {
		return alternativaCorreta;
	}
	public void setAlternativaCorreta(String alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
	
	
	

}
