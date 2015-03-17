package services;

import java.util.List;

import persistence.SMSInscrit;

public interface ISMSInscritService {
	public boolean save(SMSInscrit SMSIns);
	public List<SMSInscrit> getAll();
	public SMSInscrit getById(Long id);
	public boolean delete(SMSInscrit SMSIns);
	public boolean update(SMSInscrit SMSIns);
	public SMSInscrit rechercher( Long id, Integer cin_inscrit);
}
