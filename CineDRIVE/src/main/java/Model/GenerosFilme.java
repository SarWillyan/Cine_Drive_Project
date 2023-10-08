package Model;

import java.util.ArrayList;
import java.util.List;

public class GenerosFilme {
	// >>>>>>>>>>> ATRIBUTOS
	private int id_filme;
	private List<String> generos =  new ArrayList<String>();
	
	// >>>>>>>>>>> GETTERS AND SETTERS
	public int getId_filme() {
		return id_filme;
	}
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	public List<String> getIds_generos() {
		return generos;
	}
	public void setGeneros(String ids_generos) {
		this.generos.add(ids_generos);
	}
	
}
