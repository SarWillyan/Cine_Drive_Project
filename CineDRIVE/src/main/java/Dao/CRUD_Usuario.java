package Dao;

import java.util.List;

import Model.Usuario;

public interface CRUD_Usuario {
	
	public void create(Usuario usuario);
	public void delete(int usuarioId);
	public List<Usuario> find(String pesquisa);
	public Usuario findByEmail(String email);
	public void update(Usuario usuario);
}
