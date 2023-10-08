package Dao;

import java.util.List;

import Model.GenerosFilme;

public interface CRUD_GenerosFilme {
	
	public void create(GenerosFilme generosFilme);
	public List<String> findGendersByMovie(int filmeId);

}
