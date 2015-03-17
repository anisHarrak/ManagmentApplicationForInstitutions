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

import persistence.Etablissement;
import services.EtablissementService;
import services.IEtablissementService;

@Component
@Scope("session")
@Qualifier("etablissementCtrl")
public class EtablissementCtrl {
	private Etablissement newEtablissement = new Etablissement();
	private Etablissement editEtablissement;
	private SimpleSelection selection;
	private IEtablissementService etablissementService=EtablissementService.instance;
	private String messageValNOM;
	private String messageValAdresse;
	private String messageValNum_tel;
	private String messageValNum_fax;
	private String messageValEmail;
	private String messageValNomRespo;
	private String messageValNbr_etudiant;
	private String messageValMot_cle;
	private HtmlExtendedDataTable table;
	private List<Etablissement> selectedEtablissements = new ArrayList<Etablissement>();
	private ExtendedTableDataModel<Etablissement> dataModel;
	private List<Etablissement> etablissements = new ArrayList<Etablissement>();
	
public void setEtablissementService(IEtablissementService etablissementService) {
		
		this.etablissementService = etablissementService;
	}
		public IEtablissementService getEtablissementService() {
		return etablissementService;
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
			setMessageValNOM("");
			setMessageValAdresse("");
			setMessageValEmail("");
			setMessageValMot_cle("");
			setMessageValNbr_etudiant("");
			setMessageValNomRespo("");
			setMessageValNum_fax("");
			setMessageValNum_fax("");
		}
	public String createEtablissement() {
	String nom=String.valueOf(newEtablissement.getNom().toString());
	String adresse=newEtablissement.getAdresse();
	String num_tel=String.valueOf(newEtablissement.getNum_tel());
	String num_fax=String.valueOf(newEtablissement.getNum_fax());
	String email=String.valueOf(newEtablissement.getEmail_etab());
	String nom_respo=String.valueOf(newEtablissement.getNom_respo());	
	String nbr_etudiant=String.valueOf(newEtablissement.getNbr_etudiant());
	String mot_cle=newEtablissement.getMot_cle();
	
	clean();
		
	boolean valid1=false;
	boolean valid2=false;
	boolean valid3=false;
	boolean valid4=false;
	boolean valid5=false;
	boolean valid6=false;
	boolean valid7=false;
	boolean valid8=false;
		
	if( !nom.isEmpty()&& !isInteger(nom)){
		valid1=true;
		}else{
			valid1=false;
			setMessageValNOM("veuillez saisir un nom");
		return null;

	}
	if( !adresse.isEmpty()&& !isInteger(adresse)){
	valid2=true;	
	}
		else{
			setMessageValAdresse("veuillez saisir une adresse");
	valid2=false;
	return null;	
	}
			
if( isInteger(num_tel)&& !num_tel.isEmpty()){
	valid3=true;
}
	else{
		setMessageValNum_tel("veuillez saisir un numéro valide");
		valid3=false;
	return null;}
			
if( isInteger(num_fax)&&!num_fax.isEmpty()){
	valid4=true;
}
	else{
		setMessageValNum_fax("veuillez saisir un numéro valide");
		valid4=false;
	return null;}

if( !email.isEmpty()&& !isInteger(email)){
	valid5=true;	
	}
		else{
			setMessageValEmail("veuillez saisir un email valide");
	valid5=false;
	return null;	
	}
if( !nom_respo.isEmpty()&& !isInteger(nom_respo)){
	valid6=true;	
	}
		else{
			setMessageValEmail("veuillez saisir un nom du responsable");
	valid6=false;
	return null;	
	}
if( isInteger(nbr_etudiant)&& !nbr_etudiant.isEmpty()){
	valid7=true;
}
	else{
		setMessageValNbr_etudiant("Valeur erronée");
		valid7=false;
	return null;}

if( !mot_cle.isEmpty()&& !isInteger(mot_cle)){
	valid8=true;	
	}
		else{
			setMessageValMot_cle("veuillez saisir un mot clé");
	valid8=false;
	return null;	
	}
							
if(valid1&valid2&valid3&valid4&valid5&valid6&valid7&valid8){

etablissementService.save(newEtablissement);
newEtablissement = new Etablissement();
return "list";}
								
return "";
}


	public String deleteEtablissement() {
		Etablissement e = (Etablissement) getSelectedEtablissements().iterator().next();
		etablissementService.delete(e);
		resetSelection();
		getEtablissements();
		return null;
	}

	public String editerEtablissement() {
		editEtablissement = (Etablissement) getSelectedEtablissements().iterator().next();
	
		return "edit";
	}

	public String updateEtablissement() {
		etablissementService.update(editEtablissement);
		getEtablissements();
		return "list";
	}

	public List<Etablissement> getEtablissements() {
		etablissements = etablissementService.getAll();
		return etablissements;
	}
	
	public Etablissement getNewEtablissement() {
		return newEtablissement;
	}

	public void setNewEtablissement(Etablissement etablissement) {
		this.newEtablissement = etablissement;
	}

	public Etablissement getEditEtablissement() {
		return editEtablissement;
	}

	public void setEditEtablissement(Etablissement editEtablissement) {
		this.editEtablissement = editEtablissement;
	}

	public void takeSelection() {
		getSelectedEtablissements().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedEtablissements().add((Etablissement) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedEtablissements().clear();
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

	public List<Etablissement> getSelectedEtablissements() {
		return selectedEtablissements;
	}

	public void setSelectedEtablissements(List<Etablissement> selectedEtablissements) {
		this.selectedEtablissements = selectedEtablissements;
	}

	public void setEtablissements(List<Etablissement> etablissements) {
		this.etablissements = etablissements;
	}

	public ExtendedTableDataModel<Etablissement> getEtablissementsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Etablissement>(
					new DataProvider<Etablissement>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Etablissement getItemByKey(Object key) {
							for (Etablissement c : etablissements) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Etablissement> getItemsByRange(int firstRow,
								int endRow) {
							return etablissements.subList(firstRow, endRow);
						}

						public Object getKey(Etablissement item) {
							return item.getNom();
						}

						public int getRowCount() {
							return etablissements.size();
						}

					});
		}
		return dataModel;
	}
	public String getMessageValNOM() {
		return messageValNOM;
	}
	public void setMessageValNOM(String messageValNOM) {
		this.messageValNOM = messageValNOM;
	}
	public String getMessageValAdresse() {
		return messageValAdresse;
	}
	public void setMessageValAdresse(String messageValAdresse) {
		this.messageValAdresse = messageValAdresse;
	}
	public String getMessageValNum_tel() {
		return messageValNum_tel;
	}
	public void setMessageValNum_tel(String messageValNumTel) {
		messageValNum_tel = messageValNumTel;
	}
	public String getMessageValNum_fax() {
		return messageValNum_fax;
	}
	public void setMessageValNum_fax(String messageValNumFax) {
		messageValNum_fax = messageValNumFax;
	}
	public String getMessageValEmail() {
		return messageValEmail;
	}
	public void setMessageValEmail(String messageValEmail) {
		this.messageValEmail = messageValEmail;
	}
	public String getMessageValNomRespo() {
		return messageValNomRespo;
	}
	public void setMessageValNomRespo(String messageValNomRespo) {
		this.messageValNomRespo = messageValNomRespo;
	}
	public String getMessageValNbr_etudiant() {
		return messageValNbr_etudiant;
	}
	public void setMessageValNbr_etudiant(String messageValNbrEtudiant) {
		messageValNbr_etudiant = messageValNbrEtudiant;
	}
	public String getMessageValMot_cle() {
		return messageValMot_cle;
	}
	public void setMessageValMot_cle(String messageValMotCle) {
		messageValMot_cle = messageValMotCle;
	}
	
}
