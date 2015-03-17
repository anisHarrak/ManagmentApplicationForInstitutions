package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.SMS;

@Repository
@Transactional
public class SMSDAO implements ISMSDAO{
private EntityManager entityManager;
	
	public SMSDAO(){
		System.out.println("-----------------------chargement SMSDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public SMS getById(Long id) {
		return entityManager.find(SMS.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<SMS> getAll() {
		List<SMS> smss = entityManager.createQuery("select s from sms s").getResultList();

		return smss;
	}

	
	public boolean save(SMS sms) {
		entityManager.persist(sms);
		
		return true;
	}

	@Override
	public boolean update(SMS sms) {
		entityManager.merge(sms);
		return true;
	}

	@Override
	public boolean delete(SMS sms) {
		sms = entityManager.getReference(SMS.class, sms.getId());
		if (sms == null)
			return false;
		entityManager.merge(sms);
		entityManager.remove(sms);
		return true;
	}
	public SMS rechercher( Long id, Integer cin_sms){
		
		return entityManager.find(SMS.class, cin_sms);
	}
	
}
