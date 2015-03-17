package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Etablissement;
import dao.IEtablissementDAO;

@Repository
@Transactional
@Service
public class EtablissementService implements IEtablissementService {
	public static EtablissementService instance;
	   
	private IEtablissementDAO etablissementDAO;

	
	public EtablissementService(){
		instance=this;
		System.out.println("---------------------chargement  EtablissementService ----------------------");
	
	}
	
	public IEtablissementDAO getEtablissementDAO() {
		return etablissementDAO;
	}
	@Autowired
	public void setEtablissementDAO(IEtablissementDAO etablissementDAO) {
		
		System.out.println("injection etablissementDAO");
		this.etablissementDAO = etablissementDAO;
	}
	
	
	public Etablissement getById(Long id) {
		return etablissementDAO.getById(id);
	}
	
	public List<Etablissement> getAll() {
		return etablissementDAO.getAll();
	}
	public boolean update(Etablissement etablissement){
		return etablissementDAO.update(etablissement);
		
	}
	public Etablissement rechercher(Long id, String nom_etab){
		return etablissementDAO.rechercher(id, nom_etab);
	}
	
	public boolean save(Etablissement etablissement){
		return etablissementDAO.save(etablissement);
		
	}
	public boolean delete(Etablissement etablissement){
		return etablissementDAO.delete(etablissement);
		
	}
}
