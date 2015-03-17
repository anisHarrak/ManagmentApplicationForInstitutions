package persistence;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="sms")
public class SMS {
	@Id
	@GeneratedValue
	
	private Integer id;	
	private Integer cin_sms;	
	private boolean  etat;	
	private Date date;	
	private static int compteur;
	private String operateur;
	
	//constructors
	public SMS(Integer id) {
		super();
		this.id = id;
	}
	
	public SMS(Integer id,Integer cin, boolean etat, Date date,String operateur) {
		super();
		this.id = id;
		this.cin_sms = cin;
		this.etat = etat;
		this.date = date;
		this.operateur=operateur;
	}

	public SMS() {
		super();
		
	}
	//getters and setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCin() {
		return cin_sms;
	}
	public void setCin(Integer cin) {
		this.cin_sms = cin;
	}
	
	
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static int getCompteur() {
		return compteur;
	}
	public static void setCompteur(int compteur) {
		SMS.compteur = compteur;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Session getSession() {
		return session;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public String getOperateur() {
		return operateur;
	}

	//mapping
	@ManyToOne
	(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinColumn(name="sms_sessionID")
	private Session session;

}
