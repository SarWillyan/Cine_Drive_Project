package Dao;

import java.util.List;

import Model.Comentario;

public interface CRUD_Comentario {
	
	public void create(Comentario comentario);
	public List<Comentario> findByMovie(int filmeId);
	
}
