package dao;

import java.util.List;

import persistence.Resultat;

public interface IResultatDAO {
	public boolean save(Resultat resultat);
	public List<Resultat> getAll();
	public Resultat getById(Long id);
	public boolean delete(Resultat resultat);
	public boolean update(Resultat resultat);
	public Resultat rechercher( Long id, Integer cin_res);
}
