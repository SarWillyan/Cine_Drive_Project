package Model;

public class Upload {
	
	// >>>>>>>>> ATRIBUTOS
	private int id_usuario;
	private int id_filme;
	String video_path;
	String data_registro;
	
	// >>>>>>>>> GETTERS AND SETTERS
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
	public String getVideo_path() {
		return video_path;
	}
	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}
	public String getData_registro() {
		return data_registro;
	}
	public void setData_registro(String data_registro) {
		this.data_registro = data_registro;
	}
	
	
}
