package Dao;

import java.util.List;

import Model.Upload;

public interface CRUD_Upload {
	
	public void create(Upload upload);
	public List<Upload> findByUserId(int usuarioId);
	public Upload findByMovieId(int filmeId);
	
}
