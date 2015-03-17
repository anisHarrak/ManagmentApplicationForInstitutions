package persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name="admin")
public class Admin  {
	@Id
	@GeneratedValue
	protected Integer id;
	protected String login;	
	protected String mot_de_passe;	
	protected String type_user;
	private Integer numero_admin;
	
	//constructors
	public Admin() {
		super();
		
	}
	public Admin(Integer id,String login, String motDePasse, Integer numero_admin) {
		
		this.id = id;
		this.login=login;
		this.mot_de_passe=motDePasse;
		this.numero_admin = numero_admin;
		
	}
	//getters and setters
	
	
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
	public Integer getNumero_admin() {
		return numero_admin;
	}
	public void setNumero_admin(Integer numero_admin) {
		this.numero_admin = numero_admin;
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
	@JoinColumn(name="admin_utilisateurID")
	private Utilisateur utilisateur;
}
