package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Module;

import dao.IModuleDAO;

@Repository
@Transactional
@Service
public class ModuleService implements IModuleService {
	public static ModuleService instance;
	   
	private IModuleDAO moduleDAO;

	
	public ModuleService(){
		instance=this;
		System.out.println("---------------------chargement  ModuleService ----------------------");
	
	}
	
	public IModuleDAO getModuleDAO() {
		return moduleDAO;
	}
	@Autowired
	public void setModuleDAO(IModuleDAO moduleDAO) {
		
		System.out.println("injection moduleDAO");
		this.moduleDAO = moduleDAO;
	}
	
	
	public Module getById(Long id) {
		return moduleDAO.getById(id);
	}
	
	public List<Module> getAll() {
		return moduleDAO.getAll();
	}
	public boolean update(Module module){
		return moduleDAO.update(module);
		
	}
	public Module rechercher(Long id, String titre){
		return moduleDAO.rechercher(id, titre);
	}
	
	public boolean save(Module module){
		return moduleDAO.save(module);
		
	}
	public boolean delete(Module module){
		return moduleDAO.delete(module);
		
	}
		
}
