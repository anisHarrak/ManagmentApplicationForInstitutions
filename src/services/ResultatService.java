package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Resultat;
import dao.IResultatDAO;

@Repository
@Transactional
@Service
public class ResultatService implements IResultatService {
	public static ResultatService instance;
	   
	private IResultatDAO resultatDAO;

	
	public ResultatService(){
		instance=this;
		System.out.println("---------------------chargement  ResultatService ----------------------");
	
	}
	
	public IResultatDAO getResultatDAO() {
		return resultatDAO;
	}
	@Autowired
	public void setResultatDAO(IResultatDAO resultatDAO) {
		
		System.out.println("injection resultatDAO");
		this.resultatDAO = resultatDAO;
	}
	
	
	public Resultat getById(Long id) {
		return resultatDAO.getById(id);
	}
	
	public List<Resultat> getAll() {
		return resultatDAO.getAll();
	}
	public boolean update(Resultat resultat){
		return resultatDAO.update(resultat);
		
	}
	public Resultat rechercher(Long id, Integer cin_res){
		return resultatDAO.rechercher(id, cin_res);
	}
	
	public boolean save(Resultat resultat){
		return resultatDAO.save(resultat);
		
	}
	public boolean delete(Resultat resultat){
		return resultatDAO.delete(resultat);
		
	}
}
