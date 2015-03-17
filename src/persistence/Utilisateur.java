package persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity(name="utilisateur")

public class Utilisateur {
	@Id
	@GeneratedValue	
	protected Integer id;	
	protected String login;	
	protected String mot_de_passe;	
	protected String type_user;
	
	//constructors
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(Integer id) {
		super();
		this.id = id;
	}

	public Utilisateur( Integer id,String login, String motDePasse) {
		super();
		this.id = id;
		this.login = login;
		this.mot_de_passe = motDePasse;
		
	}

	public Utilisateur(Integer id,String login, String motDePasse,String type) {
		super();
		this.id=id;
		this.login = login;
		this.mot_de_passe = motDePasse;
		this.type_user=type;
	}

	//getters and setters
	
	public Integer getId() {
		return id;
	}
	
	public String getType_user() {
		return type_user;
	}

	public void setType_user(String typeUser) {
		type_user = typeUser;
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
	

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}

	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}
	//mapping
	@ManyToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy = "utilisateurs",
			targetEntity = Module.class 
		)
	private List<Module> moduleList;
	
	@ManyToOne
	(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinColumn(name="utilisateur_sessionID")
	private Session session;
	

}


