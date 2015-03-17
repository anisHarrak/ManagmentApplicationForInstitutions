package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.SMSInscrit;
import dao.ISMSInscritDAO;

@Repository
@Transactional
@Service
public class SMSInscritService implements ISMSInscritService {
	public static SMSInscritService instance;
	   
	private ISMSInscritDAO sMSInscritDAO;

	
	public SMSInscritService(){
		instance=this;
		System.out.println("---------------------chargement  SMSInscritService ----------------------");
	
	}
	
	public ISMSInscritDAO getSMSInscritDAO() {
		return sMSInscritDAO;
	}
	@Autowired
	public void setSMSInscritDAO(ISMSInscritDAO sMSInscritDAO) {
		
		System.out.println("injection sMSInscritDAO");
		this.sMSInscritDAO = sMSInscritDAO;
	}
	
	
	public SMSInscrit getById(Long id) {
		return sMSInscritDAO.getById(id);
	}
	
	public List<SMSInscrit> getAll() {
		return sMSInscritDAO.getAll();
	}
	public boolean update(SMSInscrit sMSInscrit){
		return sMSInscritDAO.update(sMSInscrit);
		
	}
	public SMSInscrit rechercher(Long id, Integer cin_inscrit){
		return sMSInscritDAO.rechercher(id, cin_inscrit);
	}
	
	public boolean save(SMSInscrit sMSInscrit){
		return sMSInscritDAO.save(sMSInscrit);
		
	}
	public boolean delete(SMSInscrit sMSInscrit){
		return sMSInscritDAO.delete(sMSInscrit);
		
	}
}
