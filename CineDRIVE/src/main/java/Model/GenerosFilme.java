package Model;

import java.util.ArrayList;
import java.util.List;

public class GenerosFilme {
	// >>>>>>>>>>> ATRIBUTOS
	private int id_filme;
	private List<Integer> ids_generos =  new ArrayList<Integer>();
	
	// >>>>>>>>>>> GETTERS AND SETTERS
	public int getId_filme() {
		return id_filme;
	}
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	public List<Integer> getIds_generos() {
		return ids_generos;
	}
	public void setIds_generos(int ids_generos) {
		this.ids_generos.add(ids_generos);
	}
	
}
