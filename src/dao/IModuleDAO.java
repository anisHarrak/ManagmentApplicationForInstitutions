package dao;

import java.util.List;

import persistence.Module;

public interface IModuleDAO {
	public boolean save(Module module);
	public List<Module> getAll();
	public Module getById(Long id);
	public boolean delete(Module module);
	public boolean update(Module module);
	public Module rechercher( Long id, String titre);
}
