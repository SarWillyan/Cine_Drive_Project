package Model;

public class Comentario {
	// >>>>>>>>>>>> ATRIBUTOS
	private int id_filme;
	private int id_usuario;
	private String comentario;
	private String data_comentario;
	
	// >>>>>>>>>>>> GETTERS AND SETTERS
	public int getId_filme() {
		return id_filme;
	}
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getData_comentario() {
		return data_comentario;
	}
	public void setData_comentario(String data_comentario) {
		this.data_comentario = data_comentario;
	}
}
