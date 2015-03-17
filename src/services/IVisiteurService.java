package services;

import java.util.List;

import persistence.Visiteur;

public interface IVisiteurService {
	public boolean save(Visiteur visiteur);
	public List<Visiteur> getAll();
	public Visiteur getById(Long id);
	public boolean delete(Visiteur visiteur);
	public boolean update(Visiteur visiteur);
	public Visiteur rechercher( Long id, String login);
}
