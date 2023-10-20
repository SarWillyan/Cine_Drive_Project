package Dao;

import java.util.List;

import Model.Usuario;

public interface CRUD_Usuario {
	
	public void create(Usuario usuario);
	public void delete(int usuarioId);
	public List<Usuario> findTopUsers();
	public Usuario findByEmail(String email);
	public Usuario findById(int usuarioId);
	public void update(Usuario usuario);
}
