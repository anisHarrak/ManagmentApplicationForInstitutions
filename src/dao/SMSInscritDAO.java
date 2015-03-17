package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.SMSInscrit;

@Repository
@Transactional
public class SMSInscritDAO implements ISMSInscritDAO {
private EntityManager entityManager;
	
	public SMSInscritDAO(){
		System.out.println("-----------------------chargement SMSInscritDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public SMSInscrit getById(Long id) {
		return entityManager.find(SMSInscrit.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<SMSInscrit> getAll() {
		List<SMSInscrit> sMSInscrit = entityManager.createQuery("select si from sms_inscript si").getResultList();

		return sMSInscrit;
	}

	
	public boolean save(SMSInscrit sMSInscrit) {
		entityManager.persist(sMSInscrit);
		
		return true;
	}

	@Override
	public boolean update(SMSInscrit sMSInscrit) {
		entityManager.merge(sMSInscrit);
		return true;
	}

	@Override
	public boolean delete(SMSInscrit sMSInscrit) {
		sMSInscrit = entityManager.getReference(SMSInscrit.class, sMSInscrit.getId());
		if (sMSInscrit == null)
			return false;
		entityManager.merge(sMSInscrit);
		entityManager.remove(sMSInscrit);
		return true;
	}
	public SMSInscrit rechercher( Long id, Integer cin_inscrit){
		
		return entityManager.find(SMSInscrit.class, cin_inscrit);
	}
	
}
