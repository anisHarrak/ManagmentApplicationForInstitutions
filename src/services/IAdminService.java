package services;

import java.util.List;

import persistence.Admin;

public interface IAdminService {
	public boolean save(Admin admin);
	public List<Admin> getAll();
	public Admin getById(Long id);
	public boolean delete(Admin admin);
	public boolean update(Admin admin);
	public Admin rechercher( Long id, String login);
}
