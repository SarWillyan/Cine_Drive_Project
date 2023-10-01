package Model;

public class Avaliacao {
	// >>>>>>>>>> ATRIBUTOS
	private int id_usuario;
	private int id_filme;
	private int nota;
	private String data_avalicao;
	
	// >>>>>>>>>> GETTERS and SETTERS
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_filme() {
		return id_filme;
	}
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getData_avalicao() {
		return data_avalicao;
	}
	public void setData_avalicao(String data_avalicao) {
		this.data_avalicao = data_avalicao;
	}
	
}
