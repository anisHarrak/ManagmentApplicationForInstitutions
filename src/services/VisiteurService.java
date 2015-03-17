package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Visiteur;
import dao.IVisiteurDAO;
@Repository
@Transactional
@Service
public class VisiteurService implements IVisiteurService {

	public static VisiteurService instance;
	   
	private IVisiteurDAO visiteurDAO;

	
	public VisiteurService(){
		instance=this;
		System.out.println("---------------------chargement  VisiteurService ----------------------");
	
	}
	
	public IVisiteurDAO getVisiteurDAO() {
		return visiteurDAO;
	}
	@Autowired
	public void setVisiteurDAO(IVisiteurDAO visiteurDAO) {
		
		System.out.println("injection visiteurDAO");
		this.visiteurDAO = visiteurDAO;
	}
	
	
	public Visiteur getById(Long id) {
		return visiteurDAO.getById(id);
	}
	
	public List<Visiteur> getAll() {
		return visiteurDAO.getAll();
	}
	public boolean update(Visiteur visiteur){
		return visiteurDAO.update(visiteur);
		
	}
	public Visiteur rechercher(Long id, String login){
		return visiteurDAO.rechercher(id, login);
	}
	
	public boolean save(Visiteur visiteur){
		return visiteurDAO.save(visiteur);
		
	}
	public boolean delete(Visiteur visiteur){
		return visiteurDAO.delete(visiteur);
		
	}
		
}
