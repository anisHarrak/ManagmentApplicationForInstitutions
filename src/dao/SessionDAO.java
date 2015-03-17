package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Session;

@Repository
@Transactional
public class SessionDAO implements ISessionDAO{
private EntityManager entityManager;
	
	public SessionDAO(){
		System.out.println("-----------------------chargement SessionDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Session getById(Long id) {
		return entityManager.find(Session.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Session> getAll() {
		List<Session> sessions = entityManager.createQuery("select s from session s").getResultList();

		return sessions;
	}

	
	public boolean save(Session session) {
		entityManager.persist(session);
		
		return true;
	}

	@Override
	public boolean update(Session session) {
		entityManager.merge(session);
		return true;
	}

	@Override
	public boolean delete(Session session) {
		session = entityManager.getReference(Session.class, session.getId());
		if (session == null)
			return false;
		entityManager.merge(session);
		entityManager.remove(session);
		return true;
	}
	public Session rechercher( Long id, String nom_session){
		
		return entityManager.find(Session.class, nom_session);
	}
	
}
