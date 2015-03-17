package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.Session;
import dao.ISessionDAO;

@Repository
@Transactional
@Service
public class SessionService implements ISessionService {
	public static SessionService instance;
	   
	private ISessionDAO sessionDAO;

	
	public SessionService(){
		instance=this;
		System.out.println("---------------------chargement  SessionService ----------------------");
	
	}
	
	public ISessionDAO getSessionDAO() {
		return sessionDAO;
	}
	@Autowired
	public void setSessionDAO(ISessionDAO sessionDAO) {
		
		System.out.println("injection sessionDAO");
		this.sessionDAO = sessionDAO;
	}
	
	
	public Session getById(Long id) {
		return sessionDAO.getById(id);
	}
	
	public List<Session> getAll() {
		return sessionDAO.getAll();
	}
	public boolean update(Session session){
		return sessionDAO.update(session);
		
	}
	public Session rechercher(Long id, String nom_session){
		return sessionDAO.rechercher(id, nom_session);
	}
	
	public boolean save(Session session){
		return sessionDAO.save(session);
		
	}
	public boolean delete(Session session){
		return sessionDAO.delete(session);
		
	}
}
