package Dao;

import java.util.List;

import Model.Genero;

public interface CRUD_Genero {
	
	public void create(Genero genero);
	public void delete(int generoId);
	public List<Genero> find();
	
}
