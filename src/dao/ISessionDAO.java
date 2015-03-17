package dao;

import java.util.List;

import persistence.Session;

public interface ISessionDAO {
	public boolean save(Session session);
	public List<Session> getAll();
	public Session getById(Long id);
	public boolean delete(Session session);
	public boolean update(Session session);
	public Session rechercher( Long id, String nom_session);
}
