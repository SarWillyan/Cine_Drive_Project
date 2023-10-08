package Dao;

import java.util.List;

import Model.Filme;

public interface CRUD_Filme {

	public void create(Filme filme);
	public void delete(int filmeId);
	public int findLastMovie();
	public Filme findById(int filmeId);
	public List<Filme> findByName(String nome);
	public List<Filme> findByGender(String genero);
	public List<Filme> findMovies();
	public List<Filme> findTopMovies();
	public void update(int filmeId);
	
}
