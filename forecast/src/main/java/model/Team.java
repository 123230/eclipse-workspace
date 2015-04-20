package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "T_ST_TEAM" database table.
 * 
 */
@Entity
@Table(name="\"T_ST_TEAM\"")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"SID\"", unique=true, nullable=false, length=16)
	private String sid;

	@Column(name="\"NAME\"", length=255)
	private String name;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="TStTeam")
	private Set<Person> TStPersons;

	//bi-directional many-to-many association to Forecastprojekt
	@ManyToMany
	@JoinColumns({
		})
	private Set<Forecastprojekt> TFps;

	public Team() {
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getTStPersons() {
		return this.TStPersons;
	}

	public void setTStPersons(Set<Person> TStPersons) {
		this.TStPersons = TStPersons;
	}

	public Person addTStPerson(Person TStPerson) {
		getTStPersons().add(TStPerson);
		TStPerson.setTStTeam(this);

		return TStPerson;
	}

	public Person removeTStPerson(Person TStPerson) {
		getTStPersons().remove(TStPerson);
		TStPerson.setTStTeam(null);

		return TStPerson;
	}

	public Set<Forecastprojekt> getTFps() {
		return this.TFps;
	}

	public void setTFps(Set<Forecastprojekt> TFps) {
		this.TFps = TFps;
	}

}