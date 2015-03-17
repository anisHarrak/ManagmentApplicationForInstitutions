package persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "module")
public class Module {
	@Id
	@GeneratedValue
	private Integer id;
	private String titre;
	private String description;

	// constructors
	public Module(Integer id) {
		super();
		this.id = id;
	}

	public Module(Integer id, String titre, String description) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
	}

	public Module() {
		super();

	}

	// getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	// mapping
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(joinColumns = @JoinColumn(name = "moduleId"), inverseJoinColumns = @JoinColumn(name = "utilisateurId"))
	private List<Utilisateur> utilisateurs;

}
