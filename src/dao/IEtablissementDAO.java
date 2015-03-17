package dao;

import java.util.List;

import persistence.Etablissement;

public interface IEtablissementDAO {
	public boolean save(Etablissement etablissement);
	public List<Etablissement> getAll();
	public Etablissement getById(Long id);
	public boolean delete(Etablissement etablissement);
	public boolean update(Etablissement etablissement);
	public Etablissement rechercher( Long id, String nom_etab);
}
