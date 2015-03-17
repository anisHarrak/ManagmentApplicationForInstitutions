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


@Entity(name="sms_inscript")
public class SMSInscrit {
	@Id
	@GeneratedValue	
	private Integer id;	
	private Integer cin_inscrit;
	private Date date_inscrit;
	
	//constructors
	public SMSInscrit() {
		super();
		
	}
	
	public SMSInscrit(Integer id) {
		super();
		this.id = id;
	}

	public SMSInscrit(Integer id, Integer cin,Date date_inscrit) {
		super();
		this.id = id;
		this.cin_inscrit = cin;
		this.date_inscrit=date_inscrit;
	}

	//getters and setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCin() {
		return cin_inscrit;
	}
	public void setCin(Integer cin) {
		this.cin_inscrit = cin;
	}
	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}
	public void setDate_inscrit(Date date_inscrit) {
		this.date_inscrit = date_inscrit;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate_inscrit() {
		return date_inscrit;
	}
	//mapping
	@ManyToOne
	(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinColumn(name="sms_inscrit_sessionID")
	private Session session;
	
	
	

}