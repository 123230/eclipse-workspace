package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "T_AZ" database table.
 * 
 */
@Entity
@Table(name="\"T_AZ\"")
@NamedQuery(name="Arbeitszeit.findAll", query="SELECT a FROM Arbeitszeit a")
public class Arbeitszeit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="'T_AZ'_ID_GENERATOR", sequenceName="T_ARBEITSZEIT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="'T_AZ'_ID_GENERATOR")
	@Column(name="\"ID\"", unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="\"BIS\"")
	private Date bis;

	@Column(name="\"SID-WIW\"", length=8)
	private String sid_wiw;

	@Column(name="\"SOLLARBEITSZEIT\"")
	private Integer sollarbeitszeit;

	@Temporal(TemporalType.DATE)
	@Column(name="\"VON\"")
	private Date von;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private Person TStPerson;

	public Arbeitszeit() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBis() {
		return this.bis;
	}

	public void setBis(Date bis) {
		this.bis = bis;
	}

	public String getSid_wiw() {
		return this.sid_wiw;
	}

	public void setSid_wiw(String sid_wiw) {
		this.sid_wiw = sid_wiw;
	}

	public Integer getSollarbeitszeit() {
		return this.sollarbeitszeit;
	}

	public void setSollarbeitszeit(Integer sollarbeitszeit) {
		this.sollarbeitszeit = sollarbeitszeit;
	}

	public Date getVon() {
		return this.von;
	}

	public void setVon(Date von) {
		this.von = von;
	}

	public Person getTStPerson() {
		return this.TStPerson;
	}

	public void setTStPerson(Person TStPerson) {
		this.TStPerson = TStPerson;
	}

}