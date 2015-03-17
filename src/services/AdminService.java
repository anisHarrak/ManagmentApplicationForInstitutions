package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Admin;
import dao.IAdminDAO;

@Repository
@Transactional
@Service
public class AdminService implements IAdminService {
	public static AdminService instance;
	   
	private IAdminDAO adminDAO;

	
	public AdminService(){
		instance=this;
		System.out.println("---------------------chargement  AdminService ----------------------");
	
	}
	
	public IAdminDAO getAdminDAO() {
		return adminDAO;
	}
	@Autowired
	public void setAdminDAO(IAdminDAO adminDAO) {
		
		System.out.println("injection adminDAO");
		this.adminDAO = adminDAO;
	}
	
	
	public Admin getById(Long id) {
		return adminDAO.getById(id);
	}
	
	public List<Admin> getAll() {
		return adminDAO.getAll();
	}
	public boolean update(Admin admin){
		return adminDAO.update(admin);
		
	}
	public Admin rechercher(Long id, String login){
		return adminDAO.rechercher(id, login);
	}
	
	public boolean save(Admin admin){
		return adminDAO.save(admin);
		
	}
	public boolean delete(Admin admin){
		return adminDAO.delete(admin);
		
	}
}
