package persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="session")
public class Session {
	@Id
	@GeneratedValue
	private Integer id;	
	private String section;	
	private String annee_universitaire;
	private Date date_session;
	private String nom_session;
	private String nom_fichier_resultat;
	
			
	//constructors
	public Session() {
		super();
		
	}
	public Session(Integer id) {
		super();
		this.id = id;
	}
	
	public Session(Integer id,String section, String anneeUniversitaire, Date dateSession,
			String nomSession) {
		super();
		this.id = id;
		this.section = section;
		annee_universitaire = anneeUniversitaire;
		date_session = dateSession;
		nom_session = nomSession;
	}
	
	public Session(Integer id, String section, String anneeUniversitaire,
			Date dateSession, String nomSession, String nomFichierResultat) {
		super();
		this.id = id;
		this.section = section;
		annee_universitaire = anneeUniversitaire;
		date_session = dateSession;
		nom_session = nomSession;
		nom_fichier_resultat = nomFichierResultat;
	}
	//getters and setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate_session() {
		return date_session;
	}
	public void setDate_session(Date dateSession) {
		date_session = dateSession;
	}
	public String getNom_session() {
		return nom_session;
	}
	public void setNom_session(String nomSession) {
		nom_session = nomSession;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getAnnee_universitaire() {
		return annee_universitaire;
	}
	public void setNom_fichier_resultat(String nom_fichier_resultat) {
		this.nom_fichier_resultat = nom_fichier_resultat;
	}
	public String getNom_fichier_resultat() {
		return nom_fichier_resultat;
	}
	public void setAnnee_universitaire(String anneeUniversitaire) {
		annee_universitaire = anneeUniversitaire;
	}
	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}
	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}
	
	public void setResultatList(List<Resultat> resultatList) {
		this.resultatList = resultatList;
	}
	public List<Resultat> getResultatList() {
		return resultatList;
	}
	
	public void setSmsList(List<SMS> smsList) {
		this.smsList = smsList;
	}
	public List<SMS> getSmsList() {
		return smsList;
	}
	public void setSms_inscriptionList(List<SMSInscrit> sms_inscriptionList) {
		this.sms_inscriptionList = sms_inscriptionList;
	}
	public List<SMSInscrit> getSms_inscriptionList() {
		return sms_inscriptionList;
	}
	public void setEtabList(List<Etablissement> etabList) {
		this.etabList = etabList;
	}
	public List<Etablissement> getEtabList() {
		return etabList;
	}
	
	//mapping
	@OneToMany(mappedBy="session")
	private List<Utilisateur> utilisateurList;
	@OneToMany(mappedBy="session")
	private List<Resultat> resultatList;
	@OneToMany(mappedBy="session")
	private List<SMSInscrit> sms_inscriptionList;
	@OneToMany(mappedBy="session")
	private List<SMS> smsList;
	@OneToMany(mappedBy="session")
	private List<Etablissement> etabList;
	

}

