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

import persistence.Admin;
import persistence.Personnel;
import persistence.Utilisateur;
import persistence.Visiteur;
import services.AdminService;
import services.IAdminService;
import services.IPersonnelService;
import services.IUtilisateurService;
import services.IVisiteurService;
import services.PersonnelService;
import services.UtilisateurService;
import services.VisiteurService;
@Component
@Scope("session")
@Qualifier("utilisateurCtrl")

public class UtilisateurCtrl {
	private Utilisateur newUtilisateur = new Utilisateur();
	private Utilisateur editUtilisateur;
	private SimpleSelection selection;
	private IUtilisateurService utilisateurService=UtilisateurService.instance;
	private IPersonnelService personnelService=PersonnelService.instance;
	private IAdminService adminService=AdminService.instance;
	private IVisiteurService visiteurService=VisiteurService.instance;
	private String messageValLogin;
	private String messageValMot_de_passe;
	private String messageValType_user;
	private String messageValtest;
	private String messageValtest2;
	private HtmlExtendedDataTable table;
	private List<Utilisateur> selectedUtilisateurs = new ArrayList<Utilisateur>();
	private ExtendedTableDataModel<Utilisateur> dataModel;
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	public void setUtilisateurService(IUtilisateurService utilisateurService) {
		
		this.utilisateurService = utilisateurService;
	}
		public IUtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

public IPersonnelService getPersonnelService() {
			return personnelService;
		}
		public void setPersonnelService(IPersonnelService personnelService) {
			this.personnelService = personnelService;
		}
		public IAdminService getAdminService() {
			return adminService;
		}
		public void setAdminService(IAdminService adminService) {
			this.adminService = adminService;
		}
		public IVisiteurService getVisiteurService() {
			return visiteurService;
		}
		public void setVisiteurService(IVisiteurService visiteurService) {
			this.visiteurService = visiteurService;
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
	public String connecter(){
		
		String log=String.valueOf(newUtilisateur.getLogin().toString());
		String mptdepass=String.valueOf(newUtilisateur.getMot_de_passe().toString());
		System.out.println(log);
		System.out.println(mptdepass);
		
		clean();
		boolean valid1=false;
		boolean valid2=false;
	
		if( !log.isEmpty()&& !isInteger(log)){
			valid1=true;
			}else{
				valid1=false;
				setMessageValtest("veuillez saisir un login valide");
			return null;

		}
		if( !mptdepass.isEmpty()){
			valid2=true;
			}else{
				valid2=false;
				setMessageValtest("veuillez saisir un mot de passe valide");
			return null;

		}
		String test="";
		if(valid1&&valid2)
		{
			List<Utilisateur> utilisateurs = utilisateurService.getAll();
			List<Personnel> personnels = personnelService.getAll();
			List<Admin> admins = adminService.getAll();
			List<Visiteur> visiteurs = visiteurService.getAll();
			for(int i=0;i<utilisateurs.size();i++)
			{
				for(int j=0;j<personnels.size();j++){
					for(int k=0;k<admins.size();k++){
						for(int l=0;l<visiteurs.size();l++){				
								if(visiteurs.get(l).getLogin().compareTo(log)==0 && visiteurs.get(l).getMot_de_passe().compareTo(mptdepass)==0)
									{System.out.println("visiteur: "+visiteurs.get(l).getLogin());
									System.out.println("visiteur: "+visiteurs.get(l).getMot_de_passe());
									test="list1";
									break;
								}else if(admins.get(k).getLogin().compareTo(log)==0 && admins.get(k).getMot_de_passe().compareTo(mptdepass)==0)
								{System.out.println("admin: "+admins.get(k).getLogin());
								System.out.println("admin: "+admins.get(k).getMot_de_passe());
								test="list";
								break;
								}else if(personnels.get(j).getLogin().compareTo(log)==0 && personnels.get(j).getMot_de_passe().compareTo(mptdepass)==0)
								{System.out.println("personnel: "+personnels.get(j).getLogin());
								System.out.println("personnel: "+personnels.get(j).getMot_de_passe());
								test="list1";
								break;
								}else{
									setMessageValtest2("Mot de passe/Login non valide");
									test="";
								}
						}
					}
				}
				}
				
				
			/*	if(utilisateurs.get(i).getLogin().compareTo(log)==0 && utilisateurs.get(i).getMot_de_passe().compareTo(mptdepass)==0)
				{System.out.println("utilisateur: "+utilisateurs.get(i).getLogin());
				System.out.println("utilisateur: "+utilisateurs.get(i).getMot_de_passe());
				test="list";
				
				break;
				}else{
					setMessageValtest2("Mot de passe/Login non valide");
					test="";
				}*/
			
			return test;
			
		 }
		return "";
	}
		
		public void clean(){
			setMessageValLogin("");
			setMessageValMot_de_passe("");
			setMessageValType_user("");
			setMessageValtest("");
			setMessageValtest2("");
			}
		
	public String createUtilisateur() {
		String login=String.valueOf(newUtilisateur.getLogin().toString());
		String mptdepasse=String.valueOf(newUtilisateur.getMot_de_passe().toString());
		String typeuser=String.valueOf(newUtilisateur.getType_user().toString());
		clean();
		
		boolean valid1=false;
		boolean valid2=false;
		boolean valid3=false;
		if( !login.isEmpty()&& !isInteger(login)){
			valid1=true;
			}else{
				valid1=false;
				setMessageValLogin("veuillez saisir un login valide");
			return null;

		}
		if( !mptdepasse.isEmpty()&& !isInteger(mptdepasse)){
			valid2=true;
			}else{
				valid2=false;
				setMessageValMot_de_passe("veuillez saisir un mot de passe valide");
			return null;

		}
		if( !typeuser.isEmpty()&& !isInteger(typeuser)){
			valid3=true;
			}else{
				valid3=false;
				setMessageValType_user("veuillez saisir un type d'utilisateur valide");
			return null;

		}
		if(valid1&valid2&valid3){
		utilisateurService.save(newUtilisateur);
		newUtilisateur = new Utilisateur();
		return "list";
		}
		return "";
}


	public String deleteUtilisateur() {
		Utilisateur e = (Utilisateur) getSelectedUtilisateurs().iterator().next();
		utilisateurService.delete(e);
		resetSelection();
		getUtilisateurs();
		return null;
	}

	public String editUtilisateur() {
		editUtilisateur = (Utilisateur) getSelectedUtilisateurs().iterator().next();
	
		return "edit";
	}

	public String updateUtilisateur() {
		utilisateurService.update(editUtilisateur);
		getUtilisateurs();
		return "list";
	}

	public List<Utilisateur> getUtilisateurs() {
		utilisateurs = utilisateurService.getAll();
		return utilisateurs;
	}
	
	public Utilisateur getNewUtilisateur() {
		return newUtilisateur;
	}

	public void setNewUtilisateur(Utilisateur utilisateur) {
		this.newUtilisateur = utilisateur;
	}

	public Utilisateur getEditUtilisateur() {
		return editUtilisateur;
	}

	public void setEditUtilisateur(Utilisateur editUtilisateur) {
		this.editUtilisateur = editUtilisateur;
	}

	public void takeSelection() {
		getSelectedUtilisateurs().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedUtilisateurs().add((Utilisateur) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedUtilisateurs().clear();
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

	public List<Utilisateur> getSelectedUtilisateurs() {
		return selectedUtilisateurs;
	}

	public void setSelectedUtilisateurs(List<Utilisateur> selectedUtilisateurs) {
		this.selectedUtilisateurs = selectedUtilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public ExtendedTableDataModel<Utilisateur> getUtilisateursDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Utilisateur>(
					new DataProvider<Utilisateur>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Utilisateur getItemByKey(Object key) {
							for (Utilisateur c : utilisateurs) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Utilisateur> getItemsByRange(int firstRow,
								int endRow) {
							return utilisateurs.subList(firstRow, endRow);
						}

						public Object getKey(Utilisateur item) {
							return item.getLogin();
						}

						public int getRowCount() {
							return utilisateurs.size();
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
	public String getMessageValType_user() {
		return messageValType_user;
	}
	public void setMessageValType_user(String messageValTypeUser) {
		messageValType_user = messageValTypeUser;
	}
	public void setMessageValtest(String messageValtest) {
		this.messageValtest = messageValtest;
	}
	public String getMessageValtest() {
		return messageValtest;
	}
	public void setMessageValtest2(String messageValtest2) {
		this.messageValtest2 = messageValtest2;
	}
	public String getMessageValtest2() {
		return messageValtest2;
	}
	
	
}
