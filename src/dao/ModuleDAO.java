package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Module;

@Repository
@Transactional
public class ModuleDAO implements IModuleDAO {
private EntityManager entityManager;
	
	public ModuleDAO(){
		System.out.println("-----------------------chargement ModuleDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Module getById(Long id) {
		return entityManager.find(Module.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Module> getAll() {
		List<Module> modules = entityManager.createQuery("select m from module m").getResultList();

		return modules;
	}

	
	public boolean save(Module module) {
		entityManager.persist(module);
		
		return true;
	}

	@Override
	public boolean update(Module module) {
		entityManager.merge(module);
		return true;
	}

	@Override
	public boolean delete(Module module) {
		module = entityManager.getReference(Module.class, module.getId());
		if (module == null)
			return false;
		entityManager.merge(module);
		entityManager.remove(module);
		return true;
	}
	public Module rechercher( Long id, String titre){
		
		return entityManager.find(Module.class, titre);
	}
	
}
