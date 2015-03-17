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
import services.AdminService;
import services.IAdminService;

@Component
@Scope("session")
@Qualifier("adminCtrl")
public class AdminCtrl {
	private Admin newAdmin = new Admin();
	private Admin editAdmin;
	private SimpleSelection selection;
	private IAdminService adminService=AdminService.instance;
	private String messageValLogin;
	private String messageValMot_de_passe;
	private String messageValNumero_admin;
	private String messageValType_user;
	private HtmlExtendedDataTable table;
	private List<Admin> selectedAdmins = new ArrayList<Admin>();
	private ExtendedTableDataModel<Admin> dataModel;
	private List<Admin> admins = new ArrayList<Admin>();
	
	public void setAdminService(IAdminService adminService) {
		
		this.adminService = adminService;
	}
		public IAdminService getAdminService() {
		return adminService;
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
			setMessageValNumero_admin("");
			setMessageValType_user("");
			
		}
		
	public String createAdmin() {
	String login=newAdmin.getLogin();
	String motdepasse=newAdmin.getMot_de_passe();
	String type_user=newAdmin.getType_user();
	String numero_admin=String.valueOf(newAdmin.getNumero_admin());
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
			
	if( !type_user.isEmpty()&& !isInteger(type_user)& type_user.equalsIgnoreCase("admin")){
		valid3=true;	
		}
			else{
				setMessageValType_user("veuillez saisir un type d'utilisateur valide");
		valid3=false;
		return null;	
		}
			
if( isInteger(numero_admin)){
	valid4=true;
}
	else{
		setMessageValNumero_admin("valeur erronée, veuillez saisir un entier");
		valid4=false;
	return null;}

if(valid1&valid2&valid3&valid4){
adminService.save(newAdmin);
newAdmin = new Admin();
return "list";}
return "";
								

}


	public String deleteAdmin() {
		Admin e = (Admin) getSelectedAdmins().iterator().next();
		adminService.delete(e);
		resetSelection();
		getAdmins();
		return null;
	}

	public String editerAdmin() {
		editAdmin = (Admin) getSelectedAdmins().iterator().next();
	
		return "edit";
	}

	public String updateAdmin() {
		adminService.update(editAdmin);
		getAdmins();
		return "list";
	}

	public List<Admin> getAdmins() {
		admins = adminService.getAll();
		return admins;
	}
	
	public Admin getNewAdmin() {
		return newAdmin;
	}

	public void setNewAdmin(Admin admin) {
		this.newAdmin = admin;
	}

	public Admin getEditAdmin() {
		return editAdmin;
	}

	public void setEditAdmin(Admin editAdmin) {
		this.editAdmin = editAdmin;
	}

	public void takeSelection() {
		getSelectedAdmins().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedAdmins().add((Admin) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedAdmins().clear();
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

	public List<Admin> getSelectedAdmins() {
		return selectedAdmins;
	}

	public void setSelectedAdmins(List<Admin> selectedAdmins) {
		this.selectedAdmins = selectedAdmins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public ExtendedTableDataModel<Admin> getAdminsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Admin>(
					new DataProvider<Admin>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Admin getItemByKey(Object key) {
							for (Admin c : admins) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Admin> getItemsByRange(int firstRow,
								int endRow) {
							return admins.subList(firstRow, endRow);
						}

						public Object getKey(Admin item) {
							return item.getLogin();
						}

						public int getRowCount() {
							return admins.size();
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
	public String getMessageValNumero_admin() {
		return messageValNumero_admin;
	}
	public void setMessageValNumero_admin(String messageValNumeroAdmin) {
		messageValNumero_admin = messageValNumeroAdmin;
	}
	public String getMessageValType_user() {
		return messageValType_user;
	}
	public void setMessageValType_user(String messageValTypeUser) {
		messageValType_user = messageValTypeUser;
	}
	
	
}
