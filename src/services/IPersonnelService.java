package services;

import java.util.List;

import persistence.Personnel;

public interface IPersonnelService {
	public boolean save(Personnel personnel);
	public List<Personnel> getAll();
	public Personnel getById(Long id);
	public boolean delete(Personnel personnel);
	public boolean update(Personnel personnel);
	public Personnel rechercher( Long id, String login);
}
