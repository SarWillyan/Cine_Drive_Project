package Dao;

import Model.Avaliacao;

public interface CRUD_Avaliacao {

	public void createOrUpdate(Avaliacao avaliacao);
	public void delete(int avaliacaoId);
	public Integer countNumberOfVotes(int filmeId);
	
}
