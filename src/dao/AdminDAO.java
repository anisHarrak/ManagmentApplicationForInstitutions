package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Admin;

@Repository
@Transactional
public class AdminDAO implements IAdminDAO{
private EntityManager entityManager;
	
	public AdminDAO(){
		System.out.println("-----------------------chargement AdminDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Admin getById(Long id) {
		return entityManager.find(Admin.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Admin> getAll() {
		List<Admin> admins = entityManager.createQuery("select p from admin p").getResultList();

		return admins;
	}

	
	public boolean save(Admin admin) {
		entityManager.persist(admin);
		
		return true;
	}

	@Override
	public boolean update(Admin admin) {
		entityManager.merge(admin);
		return true;
	}

	@Override
	public boolean delete(Admin admin) {
		admin = entityManager.getReference(Admin.class, admin.getId());
		if (admin == null)
			return false;
		entityManager.merge(admin);
		entityManager.remove(admin);
		return true;
	}
	public Admin rechercher( Long id, String login){
		
		return entityManager.find(Admin.class, login);
	}
	
}
