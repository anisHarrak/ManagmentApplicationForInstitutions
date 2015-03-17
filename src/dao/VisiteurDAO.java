package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Visiteur;

@Repository
@Transactional
public class VisiteurDAO implements IVisiteurDAO {
private EntityManager entityManager;
	
	public VisiteurDAO(){
		System.out.println("-----------------------chargement VisiteurDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Visiteur getById(Long id) {
		return entityManager.find(Visiteur.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Visiteur> getAll() {
		List<Visiteur> visiteurs = entityManager.createQuery("select v from visiteur v").getResultList();

		return visiteurs;
	}

	
	public boolean save(Visiteur visiteur) {
		entityManager.persist(visiteur);
		
		return true;
	}

	@Override
	public boolean update(Visiteur visiteur) {
		entityManager.merge(visiteur);
		return true;
	}

	@Override
	public boolean delete(Visiteur visiteur) {
		visiteur = entityManager.getReference(Visiteur.class, visiteur.getId());
		if (visiteur == null)
			return false;
		entityManager.merge(visiteur);
		entityManager.remove(visiteur);
		return true;
	}
	public Visiteur rechercher( Long id, String login){
		
		return entityManager.find(Visiteur.class, login);
	}
	
}
