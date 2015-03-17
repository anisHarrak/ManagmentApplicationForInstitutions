package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Personnel;
import dao.IPersonnelDAO;

@Repository
@Transactional
@Service
public class PersonnelService implements IPersonnelService {
	public static PersonnelService instance;
	   
	private IPersonnelDAO personnelDAO;

	
	public PersonnelService(){
		instance=this;
		System.out.println("---------------------chargement  PersonnelService ----------------------");
	
	}
	
	public IPersonnelDAO getPersonnelDAO() {
		return personnelDAO;
	}
	@Autowired
	public void setPersonnelDAO(IPersonnelDAO personnelDAO) {
		
		System.out.println("injection personnelDAO");
		this.personnelDAO = personnelDAO;
	}
	
	
	public Personnel getById(Long id) {
		return personnelDAO.getById(id);
	}
	
	public List<Personnel> getAll() {
		return personnelDAO.getAll();
	}
	public boolean update(Personnel personnel){
		return personnelDAO.update(personnel);
		
	}
	public Personnel rechercher(Long id, String login){
		return personnelDAO.rechercher(id, login);
	}
	
	public boolean save(Personnel personnel){
		return personnelDAO.save(personnel);
		
	}
	public boolean delete(Personnel personnel){
		return personnelDAO.delete(personnel);
		
	}
}
