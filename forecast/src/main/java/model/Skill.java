package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "T_ST_SKILL" database table.
 * 
 */
@Entity
@Table(name="\"T_ST_SKILL\"")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"SID\"", unique=true, nullable=false, length=30)
	private String sid;

	@Column(name="\"NAME\"", length=50)
	private String name;

	//bi-directional many-to-one association to Kosten
	@OneToMany(mappedBy="TStSkill")
	private Set<Kosten> TStKosts;

	//bi-directional many-to-many association to Person
	@ManyToMany(mappedBy="TStSkills")
	private Set<Person> TStPersons;

	//bi-directional many-to-many association to Forecastprojekt
	@ManyToMany(mappedBy="TStSkills")
	private Set<Forecastprojekt> TFps;

	public Skill() {
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

	public Set<Kosten> getTStKosts() {
		return this.TStKosts;
	}

	public void setTStKosts(Set<Kosten> TStKosts) {
		this.TStKosts = TStKosts;
	}

	public Kosten addTStKost(Kosten TStKost) {
		getTStKosts().add(TStKost);
		TStKost.setTStSkill(this);

		return TStKost;
	}

	public Kosten removeTStKost(Kosten TStKost) {
		getTStKosts().remove(TStKost);
		TStKost.setTStSkill(null);

		return TStKost;
	}

	public Set<Person> getTStPersons() {
		return this.TStPersons;
	}

	public void setTStPersons(Set<Person> TStPersons) {
		this.TStPersons = TStPersons;
	}

	public Set<Forecastprojekt> getTFps() {
		return this.TFps;
	}

	public void setTFps(Set<Forecastprojekt> TFps) {
		this.TFps = TFps;
	}

}