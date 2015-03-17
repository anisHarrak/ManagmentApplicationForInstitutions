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

import persistence.Visiteur;
import services.IVisiteurService;
import services.VisiteurService;

@Component
@Scope("session")
@Qualifier("visiteurCtrl")
public class VisiteurCtrl {
	private Visiteur newVisiteur = new Visiteur();
	private Visiteur editVisiteur;
	private SimpleSelection selection;
	private IVisiteurService visiteurService=VisiteurService.instance;
	private String messageValLogin;
	private String messageValMot_de_passe;
	private String messageValCode_visiteur;
	private String messageValType_user;
	private HtmlExtendedDataTable table;
	private List<Visiteur> selectedVisiteurs = new ArrayList<Visiteur>();
	private ExtendedTableDataModel<Visiteur> dataModel;
	private List<Visiteur> visiteurs = new ArrayList<Visiteur>();
	
	public void setVisiteurService(IVisiteurService visiteurService) {
		
		this.visiteurService = visiteurService;
	}
		public IVisiteurService getVisiteurService() {
		return visiteurService;
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
			setMessageValCode_visiteur("");
			setMessageValType_user("");
			
		}
		
	public String createVisiteur() {
		String login=newVisiteur.getLogin();
		String motdepasse=newVisiteur.getMot_de_passe();
		String type_user=newVisiteur.getType_user();
		String code_visiteur=String.valueOf(newVisiteur.getCode_visiteur());
		clean();
		
		boolean valid1=false;
		boolean valid2=false;
		boolean valid3=false;
		boolean valid4=false;
		
			
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
				
		if( !type_user.isEmpty()&& !isInteger(type_user)&& type_user.equalsIgnoreCase("visiteur")){
			valid3=true;	
			}
				else{
					setMessageValType_user("veuillez saisir un type d'utilisateur valide");
			valid3=false;
			return null;	
			}
				
	if( isInteger(code_visiteur)){
		valid4=true;
	}
		else{
			setMessageValCode_visiteur("valeur erronée, veuillez saisir un entier");
			valid4=false;
		return null;}
		if(valid1&valid2&valid3&valid4){
		visiteurService.save(newVisiteur);
		newVisiteur = new Visiteur();
		return "list";}
		return "";
}


	public String deleteVisiteur() {
		Visiteur e = (Visiteur) getSelectedVisiteurs().iterator().next();
		visiteurService.delete(e);
		resetSelection();
		getVisiteurs();
		return null;
	}

	public String editerVisiteur() {
		editVisiteur = (Visiteur) getSelectedVisiteurs().iterator().next();
	
		return "edit";
	}

	public String updateVisiteur() {
		visiteurService.update(editVisiteur);
		getVisiteurs();
		return "list";
	}

	public List<Visiteur> getVisiteurs() {
		visiteurs = visiteurService.getAll();
		return visiteurs;
	}
	
	public Visiteur getNewVisiteur() {
		return newVisiteur;
	}

	public void setNewVisiteur(Visiteur visiteur) {
		this.newVisiteur = visiteur;
	}

	public Visiteur getEditVisiteur() {
		return editVisiteur;
	}

	public void setEditVisiteur(Visiteur editVisiteur) {
		this.editVisiteur = editVisiteur;
	}

	public void takeSelection() {
		getSelectedVisiteurs().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedVisiteurs().add((Visiteur) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedVisiteurs().clear();
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

	public List<Visiteur> getSelectedVisiteurs() {
		return selectedVisiteurs;
	}

	public void setSelectedVisiteurs(List<Visiteur> selectedVisiteurs) {
		this.selectedVisiteurs = selectedVisiteurs;
	}

	public void setVisiteurs(List<Visiteur> visiteurs) {
		this.visiteurs = visiteurs;
	}

	public ExtendedTableDataModel<Visiteur> getVisiteursDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Visiteur>(
					new DataProvider<Visiteur>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Visiteur getItemByKey(Object key) {
							for (Visiteur c : visiteurs) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Visiteur> getItemsByRange(int firstRow,
								int endRow) {
							return visiteurs.subList(firstRow, endRow);
						}

						public Object getKey(Visiteur item) {
							return item.getLogin();
						}

						public int getRowCount() {
							return visiteurs.size();
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
	public String getMessageValCode_visiteur() {
		return messageValCode_visiteur;
	}
	public void setMessageValCode_visiteur(String messageValCodeVisiteur) {
		messageValCode_visiteur = messageValCodeVisiteur;
	}
	public String getMessageValType_user() {
		return messageValType_user;
	}
	public void setMessageValType_user(String messageValTypeUser) {
		messageValType_user = messageValTypeUser;
	}
	
}
