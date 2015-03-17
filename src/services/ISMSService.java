package services;

import java.util.List;

import persistence.SMS;

public interface ISMSService {
	public boolean save(SMS sms);
	public List<SMS> getAll();
	public SMS getById(Long id);
	public boolean delete(SMS sms);
	public boolean update(SMS sms);
	public SMS rechercher( Long id, Integer cin_sms);
}
