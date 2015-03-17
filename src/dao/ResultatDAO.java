package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Resultat;

@Repository
@Transactional
public class ResultatDAO implements IResultatDAO{
private EntityManager entityManager;
	
	public ResultatDAO(){
		System.out.println("-----------------------chargement ResultatDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Resultat getById(Long id) {
		return entityManager.find(Resultat.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Resultat> getAll() {
		List<Resultat> resultats = entityManager.createQuery("select r from resultat r").getResultList();

		return resultats;
	}

	
	public boolean save(Resultat resultat) {
		entityManager.persist(resultat);
		
		return true;
	}

	@Override
	public boolean update(Resultat resultat) {
		entityManager.merge(resultat);
		return true;
	}

	@Override
	public boolean delete(Resultat resultat) {
		resultat = entityManager.getReference(Resultat.class, resultat.getId());
		if (resultat == null)
			return false;
		entityManager.merge(resultat);
		entityManager.remove(resultat);
		return true;
	}
	public Resultat rechercher( Long id, Integer cin_res){
		
		return entityManager.find(Resultat.class, cin_res);
	}
	
}
