package Model;

public class Filme {
	// >>>>>>>>>>>>>> ATRIBUTOS
	private int id;
	private String titulo;
	private int ano;
	private String imagem_url;
	private float nota;
	private int tempo;
	private String sinopse;
	
	// >>>>>>>>>>>>>> GETTERS AND SETTERS
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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getImagem_url() {
		return imagem_url;
	}
	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float f) {
		this.nota = f;
	}
	
}
