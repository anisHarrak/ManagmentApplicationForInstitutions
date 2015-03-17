package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import persistence.Session;
import services.ISessionService;
import services.SessionService;

@Component
@Scope("session")
@Qualifier("sessionCtrl")
public class SessionCtrl {
	private Session newSession = new Session();
	private Session editSession;
	private SimpleSelection selection;
	private ISessionService sessionService=SessionService.instance;
	private String messageValSection;
	private String messageValAnneeuniversitaire;
	private String messageValDatesession;
	private String messageValNomsession;
	private String messageValNom_fichier_res;
	private HtmlExtendedDataTable table;
	private List<Session> selectedSessions = new ArrayList<Session>();
	private ExtendedTableDataModel<Session> dataModel;
	private List<Session> sessions = new ArrayList<Session>();
	
public void setSessionService(ISessionService sessionService) {
		
		this.sessionService = sessionService;
	}
		public ISessionService getSessionService() {
		return sessionService;
	}

////////////////////////////////////////
		public boolean isValid(String c){
			try{
				System.out.println(c);
				
			float d=Float.parseFloat(c);
			if (d!=0){
			return true;
			}
			return false;
			}
			catch (Exception e) {
				
			return false;
			}
		}

//////////////////////////////////////	
	
		
		public boolean isInteger(String s){
			try {
				
			int i=Integer.valueOf(s.toString());
			if(i!=0){
				return true;
			}
			return false;
			} catch (Exception e) {
				return false;
			}
		}
		
		
		
		
/////////////////////////////////////////
	
		public void clean(){
			setMessageValSection("");
			setMessageValAnneeuniversitaire("");
			setMessageValDatesession("");
			setMessageValNomsession("");
			setMessageValNom_fichier_res("");
			
		}
	public String createSession() {
	String section=String.valueOf(newSession.getSection().toString());
	String anneeuniver=newSession.getAnnee_universitaire();
	String datesession=String.valueOf(newSession.getDate_session());
	String nomsession=String.valueOf(newSession.getNom_session());
	String nomfichierres=newSession.getNom_fichier_resultat();
	
	clean();
		
	boolean valid1=false;
	boolean valid2=false;
	boolean valid3=false;
	boolean valid4=false;
	boolean valid5=false;
	
		
	if( !section.isEmpty()&& !isInteger(section)){
		valid1=true;
		}else{
			valid1=false;
			setMessageValSection("veuillez saisir une section");
		return null;

	}
	if( !anneeuniver.isEmpty()&& !isInteger(anneeuniver)){
	valid2=true;	
	}
		else{
			setMessageValAnneeuniversitaire("veuillez saisir une date valide");
	valid2=false;
	return null;	
	}
			
if( datesession!=null){
	valid3=true;
}
	else{
		setMessageValDatesession("veuillez saisir une date valide");
		valid3=false;
	return null;}
			
if( !isInteger(nomsession)){
	valid4=true;
}
	else{
		setMessageValNomsession("veuillez saisir un nom de session");
		valid4=false;
	return null;}
if( !nomfichierres.isEmpty()&& !isInteger(nomfichierres)){
	valid5=true;
	}else{
		valid5=false;
		setMessageValNom_fichier_res("veuillez saisir un nom de fichier valid");
	return null;

}

						
if(valid1&valid2&valid3&valid4&valid5){

sessionService.save(newSession);
newSession = new Session();
return "list";}
								
return "";
}


	public String deleteSession() {
		Session e = (Session) getSelectedSessions().iterator().next();
		sessionService.delete(e);
		resetSelection();
		getSessions();
		return null;
	}

	public String editerSession() {
		editSession = (Session) getSelectedSessions().iterator().next();
		//sessionService.update(editSession);
		return "edit";
	}

	public String updateSession() {
		sessionService.update(editSession);
		getSessions();
		return "list";
	}

	public List<Session> getSessions() {
		sessions = sessionService.getAll();
		return sessions;
	}
	
	public Session getNewSession() {
		return newSession;
	}

	public void setNewSession(Session session) {
		this.newSession = session;
	}

	public Session getEditSession() {
		return editSession;
	}

	public void setEditSession(Session editSession) {
		this.editSession = editSession;
	}

	public void takeSelection() {
		getSelectedSessions().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedSessions().add((Session) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedSessions().clear();
	}

	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}

	public void setTable(HtmlExtendedDataTable table) {
		this.table = table;
	}

	public HtmlExtendedDataTable getTable() {
		return table;
	}

	public SimpleSelection getSelection() {
		return selection;
	}

	public List<Session> getSelectedSessions() {
		return selectedSessions;
	}

	public void setSelectedSessions(List<Session> selectedSessions) {
		this.selectedSessions = selectedSessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public ExtendedTableDataModel<Session> getSessionsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Session>(
					new DataProvider<Session>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Session getItemByKey(Object key) {
							for (Session c : sessions) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Session> getItemsByRange(int firstRow,
								int endRow) {
							return sessions.subList(firstRow, endRow);
						}

						public Object getKey(Session item) {
							return item.getNom_session();
						}

						public int getRowCount() {
							return sessions.size();
						}

					});
		}
		return dataModel;
	}
	public String getMessageValSection() {
		return messageValSection;
	}
	public void setMessageValSection(String messageValSection) {
		this.messageValSection = messageValSection;
	}
	public String getMessageValAnneeuniversitaire() {
		return messageValAnneeuniversitaire;
	}
	public void setMessageValAnneeuniversitaire(String messageValAnneeuniversitaire) {
		this.messageValAnneeuniversitaire = messageValAnneeuniversitaire;
	}
	public String getMessageValDatesession() {
		return messageValDatesession;
	}
	public void setMessageValDatesession(String messageValDatesession) {
		this.messageValDatesession = messageValDatesession;
	}
	public String getMessageValNomsession() {
		return messageValNomsession;
	}
	public void setMessageValNomsession(String messageValNomsession) {
		this.messageValNomsession = messageValNomsession;
	}
	public void setMessageValNom_fichier_res(String messageValNom_fichier_res) {
		this.messageValNom_fichier_res = messageValNom_fichier_res;
	}
	public String getMessageValNom_fichier_res() {
		return messageValNom_fichier_res;
	}

	
}
