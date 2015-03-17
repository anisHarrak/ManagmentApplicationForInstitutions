package persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="etablissement")
public class Etablissement {
	@Id
	@GeneratedValue
	private Integer id;	
	private String nom_etab;	
	private String adresse_etab;	
	private Integer num_tel;
	private Integer num_fax;
	private String email_etab;
	private String nom_respo;
	private Integer nbr_etudiant;
	private String mot_cle;
	
			
	//constructors
	public Etablissement(Integer id) {
		
		super();
		this.id = id;
	}
	public Etablissement(Integer id,String nom, String adresse,
			Integer numTel, String motCle) {
		super();
		this.id = id;
		this.nom_etab = nom;
		this.adresse_etab = adresse;
		this.num_tel = numTel;
		this.mot_cle = motCle;
	}
	public Etablissement( String nom, String adresse,
			Integer numTel,Integer num_fax,String email_etab,String nom_respo,Integer nbr_etudiant,String motCle) {
		super();
		this.nom_etab = nom;
		this.adresse_etab = adresse;
		this.num_tel = numTel;
		this.num_fax=num_fax;
		this.email_etab=email_etab;
		this.nom_respo=nom_respo;
		this.nbr_etudiant=nbr_etudiant;
		this.mot_cle = motCle;
	}
	public Etablissement() {
		super();
		
	}
	//getters and setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom_etab;
	}
	public void setNom(String nom) {
		this.nom_etab = nom;
	}
	public String getAdresse() {
		return adresse_etab;
	}
	public void setAdresse(String adresse) {
		this.adresse_etab = adresse;
	}
	public Integer getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(Integer numTel) {
		num_tel = numTel;
	}
	public String getMot_cle() {
		return mot_cle;
	}
	public void setMot_cle(String motCle) {
		mot_cle = motCle;
	}
		
	public String getNom_etab() {
		return nom_etab;
	}
	public void setNom_etab(String nomEtab) {
		nom_etab = nomEtab;
	}
	public String getAdresse_etab() {
		return adresse_etab;
	}
	public void setAdresse_etab(String adresseEtab) {
		adresse_etab = adresseEtab;
	}
	public Integer getNum_fax() {
		return num_fax;
	}
	public void setNum_fax(Integer numFax) {
		num_fax = numFax;
	}
	public String getEmail_etab() {
		return email_etab;
	}
	public void setEmail_etab(String emailEtab) {
		email_etab = emailEtab;
	}
	public String getNom_respo() {
		return nom_respo;
	}
	public void setNom_respo(String nomRespo) {
		nom_respo = nomRespo;
	}
	public Integer getNbr_etudiant() {
		return nbr_etudiant;
	}
	public void setNbr_etudiant(Integer nbrEtudiant) {
		nbr_etudiant = nbrEtudiant;
	}
	//mapping

	@ManyToOne
	(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinColumn(name="etablissement_sessionID")
	private Session session;
	public void setSession(Session session) {
		this.session = session;
	}
	public Session getSession() {
		return session;
	}

}

