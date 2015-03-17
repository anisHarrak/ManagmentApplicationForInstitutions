package persistence;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="resultat")
public class Resultat {
	@Id
	@GeneratedValue	
	private Integer id;	
	private String message;
	private Date date_resultat;
	private Integer cin_res;
		
	//constructors
	public Resultat(Integer id) {
		super();
		this.id = id;
	}
	public Resultat(Integer id, String message,Date date_resultat,Integer cin_res ) {
		super();
		this.id = id;
		this.message = message;
		this.date_resultat=date_resultat;
		this.cin_res=cin_res;
	}
	public Resultat() {
		super();
		
	}
	//getters and setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate_resultat() {
		return date_resultat;
	}
	public void setDate_resultat(Date dateResultat) {
		date_resultat = dateResultat;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	
	public void setCin_res(Integer cin_res) {
		this.cin_res = cin_res;
	}
	public Integer getCin_res() {
		return cin_res;
	}

	//mapping
	@ManyToOne
	(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinColumn(name="resultat_sessionID")
	private Session session;

}

