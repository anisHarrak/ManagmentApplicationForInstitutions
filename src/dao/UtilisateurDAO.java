package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import persistence.Utilisateur;

@Repository
@Transactional
public class UtilisateurDAO implements IUtilisateurDAO{
private EntityManager entityManager;
	
	public UtilisateurDAO(){
		System.out.println("-----------------------chargement UtilisateurDAO-----------------------");
	}
		
	@PersistenceContext(unitName="MEDCNAM")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Utilisateur getById(Long id) {
		return entityManager.find(Utilisateur.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAll() {
		List<Utilisateur> utilisateurs = entityManager.createQuery("select u from utilisateur u").getResultList();

		return utilisateurs;
	}
	
	@SuppressWarnings("unchecked")
	public boolean connect(String login,String mot_de_passe){
		boolean val=false;
		List<Utilisateur> utis = entityManager.createQuery("select u from utilisateur u where u.login= login").getResultList();
		for(int i=0;i<utis.size();i++){
			if(utis.get(i).getLogin()==login &&utis.get(i).getMot_de_passe()==mot_de_passe)
				val=true;
			    val=false;
		}
		return val;
	}
	
	public boolean save(Utilisateur utilisateur) {
		entityManager.persist(utilisateur);
		
		return true;
	}

	@Override
	public boolean update(Utilisateur utilisateur) {
		entityManager.merge(utilisateur);
		return true;
	}

	@Override
	public boolean delete(Utilisateur utilisateur) {
		utilisateur = entityManager.getReference(Utilisateur.class, utilisateur.getId());
		if (utilisateur == null)
			return false;
		entityManager.merge(utilisateur);
		entityManager.remove(utilisateur);
		return true;
	}
	public Utilisateur rechercher( String login){
		return entityManager.find(Utilisateur.class, login);
	}
	public Utilisateur rechercher( Long id, String login){
		
		return entityManager.find(Utilisateur.class, login);
	}
	
}
