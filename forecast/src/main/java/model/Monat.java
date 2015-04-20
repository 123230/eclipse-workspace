package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "T_MONAT" database table.
 * 
 */
@Entity
@Table(name="\"T_MONAT\"")
@NamedQuery(name="Monat.findAll", query="SELECT m FROM Monat m")
public class Monat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"SID\"", unique=true, nullable=false, length=3)
	private String sid;

	@Column(name="\"ANZAHL FREIE TAGE\"")
	private Integer anzahl_freie_tage;

	@Column(name="\"ANZAHL TAGE\"")
	private Integer anzahl_tage;

	@Column(name="\"BESCHREIBUNG\"", length=100)
	private String beschreibung;

	//bi-directional many-to-many association to Person
	@ManyToMany(mappedBy="TMonats")
	private Set<Person> TStPersons;

	public Monat() {
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getAnzahl_freie_tage() {
		return this.anzahl_freie_tage;
	}

	public void setAnzahl_freie_tage(Integer anzahl_freie_tage) {
		this.anzahl_freie_tage = anzahl_freie_tage;
	}

	public Integer getAnzahl_tage() {
		return this.anzahl_tage;
	}

	public void setAnzahl_tage(Integer anzahl_tage) {
		this.anzahl_tage = anzahl_tage;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Set<Person> getTStPersons() {
		return this.TStPersons;
	}

	public void setTStPersons(Set<Person> TStPersons) {
		this.TStPersons = TStPersons;
	}

}