package persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "personnel")
public class Personnel {
	@Id
	@GeneratedValue
	protected Integer id;
	protected String login;
	protected String mot_de_passe;
	protected String type_user;
	private String nom;
	private String prenom;

	// constructors
	public Personnel() {
		super();

	}

	public Personnel(Integer id, String login, String motDePasse,
			String typeUser, String nom, String prenom) {
		super();
		this.id = id;
		this.login = login;
		mot_de_passe = motDePasse;
		type_user = typeUser;
		this.nom = nom;
		this.prenom = prenom;
	}

	// geters and setters

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String motDePasse) {
		mot_de_passe = motDePasse;
	}

	public String getType_user() {
		return type_user;
	}

	public void setType_user(String typeUser) {
		type_user = typeUser;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "personnel_utilisateurID")
	private Utilisateur utilisateur;
}
