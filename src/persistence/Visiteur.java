package persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="visiteur")
public class Visiteur  {
	@Id
	@GeneratedValue
	protected Integer id;
	protected String login;	
	protected String mot_de_passe;	
	protected String type_user;
	protected Integer code_visiteur;
	
	//constructors
	public Visiteur() {
		super();
		
	}
	public Visiteur(Integer id, String login, String motDePasse,
			String typeUser, Integer codeVisiteur) {
		super();
		this.id = id;
		this.login = login;
		mot_de_passe = motDePasse;
		type_user = typeUser;
		code_visiteur = codeVisiteur;
	}



	//geters and setters
	
	
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

	public Integer getCode_visiteur() {
		return code_visiteur;
	}

	public void setCode_visiteur(Integer codeVisiteur) {
		code_visiteur = codeVisiteur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	@ManyToOne
	(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinColumn(name="visiteur_utilisateurID")
	private Utilisateur utilisateur;
	

}

