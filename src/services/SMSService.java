package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.SMS;
import dao.ISMSDAO;

@Repository
@Transactional
@Service
public class SMSService implements ISMSService {
	public static SMSService instance;
	   
	private ISMSDAO sMSDAO;

	
	public SMSService(){
		instance=this;
		System.out.println("---------------------chargement  SMSService ----------------------");
	
	}
	
	public ISMSDAO getSMSDAO() {
		return sMSDAO;
	}
	@Autowired
	public void setSMSDAO(ISMSDAO sMSDAO) {
		
		System.out.println("injection sMSDAO");
		this.sMSDAO = sMSDAO;
	}
	
	
	public SMS getById(Long id) {
		return sMSDAO.getById(id);
	}
	
	public List<SMS> getAll() {
		return sMSDAO.getAll();
	}
	public boolean update(SMS sMS){
		return sMSDAO.update(sMS);
		
	}
	public SMS rechercher(Long id, Integer cin_sms){
		return sMSDAO.rechercher(id, cin_sms);
	}
	
	public boolean save(SMS sMS){
		return sMSDAO.save(sMS);
		
	}
	public boolean delete(SMS sMS){
		return sMSDAO.delete(sMS);
		
	}
}
