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

import persistence.Personnel;
import services.IPersonnelService;
import services.PersonnelService;

@Component
@Scope("session")
@Qualifier("personnelCtrl")
public class PersonnelCtrl {
	private Personnel newPersonnel = new Personnel();
	private Personnel editPersonnel;
	private SimpleSelection selection;
	private IPersonnelService personnelService=PersonnelService.instance;
	private String messageValLogin;
	private String messageValMot_de_passe;
	private String messageValNom;
	private String messageValPrenom;
	private String messageValType_user;
	private HtmlExtendedDataTable table;
	private List<Personnel> selectedPersonnels = new ArrayList<Personnel>();
	private ExtendedTableDataModel<Personnel> dataModel;
	private List<Personnel> personnels = new ArrayList<Personnel>();
	
	public void setPersonnelService(IPersonnelService personnelService) {
		
		this.personnelService = personnelService;
	}
		public IPersonnelService getPersonnelService() {
		return personnelService;
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
			setMessageValLogin("");
			setMessageValMot_de_passe("");
			setMessageValNom("");
			setMessageValType_user("");
			setMessageValPrenom("");
			
		}
		
	public String createPersonnel() {
		String login=newPersonnel.getLogin();
		String motdepasse=newPersonnel.getMot_de_passe();
		String type_user=newPersonnel.getType_user();
		String nom=newPersonnel.getNom();
		String prenom=newPersonnel.getPrenom();
		clean();
		
		boolean valid1=false;
		boolean valid2=false;
		boolean valid3=false;
		boolean valid4=false;
		boolean valid5=false;
		
			
		if( !login.isEmpty()&& !isInteger(login)){
			valid1=true;
			}else{
				valid1=false;
				setMessageValLogin("veuillez saisir un login valid");
			return null;

		}
		if( !motdepasse.isEmpty()&& !isInteger(motdepasse)){
		valid2=true;	
		}
			else{
				setMessageValMot_de_passe("le mot de passe doit contenir au moins une lettre,veuillez saisir un mot de passe valide");
		valid2=false;
		return null;	
		}
				
		if( !type_user.isEmpty()&& !isInteger(type_user)& type_user.equalsIgnoreCase("personnel")){
			valid3=true;	
			}
				else{
					setMessageValType_user("veuillez saisir un type d'utilisateur valide");
			valid3=false;
			return null;	
			}
				
		if( !nom.isEmpty()&& !isInteger(nom)){
			valid4=true;	
			}
				else{
					setMessageValType_user("veuillez saisir un nom valide");
			valid4=false;
			return null;	
			}
		if( !prenom.isEmpty()&& !isInteger(prenom)){
			valid5=true;	
			}
				else{
					setMessageValType_user("veuillez saisir un prénom valide");
			valid5=false;
			return null;	
			}
		if(valid1&valid2&valid3&valid4&valid5){
		personnelService.save(newPersonnel);
		newPersonnel = new Personnel();
		return "list";}
		return "";
}


	public String deletePersonnel() {
		Personnel e = (Personnel) getSelectedPersonnels().iterator().next();
		personnelService.delete(e);
		resetSelection();
		getPersonnels();
		return null;
	}

	public String editerPersonnel() {
		editPersonnel = (Personnel) getSelectedPersonnels().iterator().next();
	
		return "edit";
	}

	public String updatePersonnel() {
		personnelService.update(editPersonnel);
		getPersonnels();
		return "list";
	}

	public List<Personnel> getPersonnels() {
		personnels = personnelService.getAll();
		return personnels;
	}
	
	public Personnel getNewPersonnel() {
		return newPersonnel;
	}

	public void setNewPersonnel(Personnel personnel) {
		this.newPersonnel = personnel;
	}

	public Personnel getEditPersonnel() {
		return editPersonnel;
	}

	public void setEditPersonnel(Personnel editPersonnel) {
		this.editPersonnel = editPersonnel;
	}

	public void takeSelection() {
		getSelectedPersonnels().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedPersonnels().add((Personnel) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedPersonnels().clear();
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

	public List<Personnel> getSelectedPersonnels() {
		return selectedPersonnels;
	}

	public void setSelectedPersonnels(List<Personnel> selectedPersonnels) {
		this.selectedPersonnels = selectedPersonnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public ExtendedTableDataModel<Personnel> getPersonnelsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Personnel>(
					new DataProvider<Personnel>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Personnel getItemByKey(Object key) {
							for (Personnel c : personnels) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Personnel> getItemsByRange(int firstRow,
								int endRow) {
							return personnels.subList(firstRow, endRow);
						}

						public Object getKey(Personnel item) {
							return item.getLogin();
						}

						public int getRowCount() {
							return personnels.size();
						}

					});
		}
		return dataModel;
	}
	public String getMessageValLogin() {
		return messageValLogin;
	}
	public void setMessageValLogin(String messageValLogin) {
		this.messageValLogin = messageValLogin;
	}
	public String getMessageValMot_de_passe() {
		return messageValMot_de_passe;
	}
	public void setMessageValMot_de_passe(String messageValMotDePasse) {
		messageValMot_de_passe = messageValMotDePasse;
	}
	public String getMessageValNom() {
		return messageValNom;
	}
	public void setMessageValNom(String messageValNom) {
		this.messageValNom = messageValNom;
	}
	public String getMessageValPrenom() {
		return messageValPrenom;
	}
	public void setMessageValPrenom(String messageValPrenom) {
		this.messageValPrenom = messageValPrenom;
	}
	public String getMessageValType_user() {
		return messageValType_user;
	}
	public void setMessageValType_user(String messageValTypeUser) {
		messageValType_user = messageValTypeUser;
	}
	
	
}
