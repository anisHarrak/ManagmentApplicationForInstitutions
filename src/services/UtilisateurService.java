package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Utilisateur;

import dao.IUtilisateurDAO;


@Repository
@Transactional
@Service
public class UtilisateurService implements IUtilisateurService {
	public static UtilisateurService instance;
	   
	private IUtilisateurDAO utilisateurDAO;

	
	public UtilisateurService(){
		instance=this;
		System.out.println("---------------------chargement  UtilisateurService ----------------------");
	
	}
	
	public IUtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}
	@Autowired
	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		
		System.out.println("injection utilisateurDAO");
		this.utilisateurDAO = utilisateurDAO;
	}
	
	
	public Utilisateur getById(Long id) {
		return utilisateurDAO.getById(id);
	}
	
	public List<Utilisateur> getAll() {
		return utilisateurDAO.getAll();
	}
	public boolean update(Utilisateur utilisateur){
		return utilisateurDAO.update(utilisateur);
		
	}
	public Utilisateur rechercher(Long id, String login){
		return utilisateurDAO.rechercher(id, login);
	}
	
	public boolean save(Utilisateur utilisateur){
		return utilisateurDAO.save(utilisateur);
		
	}
	public boolean delete(Utilisateur utilisateur){
		return utilisateurDAO.delete(utilisateur);
		
	}
	public boolean connect(String login,String mot_de_passe){
		
		return utilisateurDAO.connect(login, mot_de_passe);
	}	
}
