package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Etablissement;

@Repository
@Transactional
public class EtablissementDAO implements IEtablissementDAO {
private EntityManager entityManager;
	
	public EtablissementDAO(){
		System.out.println("-----------------------chargement EtablissementDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Etablissement getById(Long id) {
		return entityManager.find(Etablissement.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Etablissement> getAll() {
		List<Etablissement> etablissements = entityManager.createQuery("select e from etablissement e").getResultList();

		return etablissements;
	}

	
	public boolean save(Etablissement etablissement) {
		entityManager.persist(etablissement);
		
		return true;
	}

	@Override
	public boolean update(Etablissement etablissement) {
		entityManager.merge(etablissement);
		return true;
	}

	@Override
	public boolean delete(Etablissement etablissement) {
		etablissement = entityManager.getReference(Etablissement.class, etablissement.getId());
		if (etablissement == null)
			return false;
		entityManager.merge(etablissement);
		entityManager.remove(etablissement);
		return true;
	}
	public Etablissement rechercher( Long id, String nom_etab){
		
		return entityManager.find(Etablissement.class, nom_etab);
	}
	
}
