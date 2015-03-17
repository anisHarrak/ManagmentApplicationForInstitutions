package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Personnel;

@Repository
@Transactional
public class PersonnelDAO implements IPersonnelDAO {
private EntityManager entityManager;
	
	public PersonnelDAO(){
		System.out.println("-----------------------chargement PersonnelDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Personnel getById(Long id) {
		return entityManager.find(Personnel.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Personnel> getAll() {
		List<Personnel> personnels = entityManager.createQuery("select p from personnel p").getResultList();

		return personnels;
	}

	
	public boolean save(Personnel personnel) {
		entityManager.persist(personnel);
		
		return true;
	}

	@Override
	public boolean update(Personnel personnel) {
		entityManager.merge(personnel);
		return true;
	}

	@Override
	public boolean delete(Personnel personnel) {
		personnel = entityManager.getReference(Personnel.class, personnel.getId());
		if (personnel == null)
			return false;
		entityManager.merge(personnel);
		entityManager.remove(personnel);
		return true;
	}
	public Personnel rechercher( Long id, String login){
		
		return entityManager.find(Personnel.class, login);
	}
	
}
