package dao;

import java.util.List;

import persistence.Utilisateur;

public interface IUtilisateurDAO {
	public boolean save(Utilisateur utilisateur);
	public List<Utilisateur> getAll();
	public Utilisateur getById(Long id);
	public boolean delete(Utilisateur utilisateur);
	public boolean update(Utilisateur utilisateur);
	public Utilisateur rechercher( Long id, String login);
	public Utilisateur rechercher( String login);
	public boolean connect(String login,String mot_de_passe);
}
