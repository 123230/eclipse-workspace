package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "T_ST_PERSON" database table.
 * 
 */
@Entity
@Table(name="\"T_ST_PERSON\"")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"SID\"", unique=true, nullable=false, length=8)
	private String sid;

	@Column(name="\"BEREICHSLEITER\"")
	private Boolean bereichsleiter;

	@Column(name="\"NACHNAME\"", length=50)
	private String nachname;

	@Column(name="\"SID-BER\"", length=16)
	private String sid_ber;

	@Column(name="\"SID-TEAM\"", length=16)
	private String sid_team;

	@Column(name="\"TEAMLEITER\"")
	private Boolean teamleiter;

	@Column(name="\"VORNAME\"", length=50)
	private String vorname;

	//bi-directional many-to-one association to Arbeitszeit
	@OneToMany(mappedBy="TStPerson")
	private Set<Arbeitszeit> TAzs;

	//bi-directional many-to-many association to Monat
	@ManyToMany
	@JoinColumns({
		})
	private Set<Monat> TMonats;

	//bi-directional many-to-one association to Bereich
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private Bereich TStBer;

	//bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinColumns({
		})
	private Set<Skill> TStSkills;

	//bi-directional many-to-one association to Team
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private Team TStTeam;

	public Person() {
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Boolean getBereichsleiter() {
		return this.bereichsleiter;
	}

	public void setBereichsleiter(Boolean bereichsleiter) {
		this.bereichsleiter = bereichsleiter;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getSid_ber() {
		return this.sid_ber;
	}

	public void setSid_ber(String sid_ber) {
		this.sid_ber = sid_ber;
	}

	public String getSid_team() {
		return this.sid_team;
	}

	public void setSid_team(String sid_team) {
		this.sid_team = sid_team;
	}

	public Boolean getTeamleiter() {
		return this.teamleiter;
	}

	public void setTeamleiter(Boolean teamleiter) {
		this.teamleiter = teamleiter;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Set<Arbeitszeit> getTAzs() {
		return this.TAzs;
	}

	public void setTAzs(Set<Arbeitszeit> TAzs) {
		this.TAzs = TAzs;
	}

	public Arbeitszeit addTAz(Arbeitszeit TAz) {
		getTAzs().add(TAz);
		TAz.setTStPerson(this);

		return TAz;
	}

	public Arbeitszeit removeTAz(Arbeitszeit TAz) {
		getTAzs().remove(TAz);
		TAz.setTStPerson(null);

		return TAz;
	}

	public Set<Monat> getTMonats() {
		return this.TMonats;
	}

	public void setTMonats(Set<Monat> TMonats) {
		this.TMonats = TMonats;
	}

	public Bereich getTStBer() {
		return this.TStBer;
	}

	public void setTStBer(Bereich TStBer) {
		this.TStBer = TStBer;
	}

	public Set<Skill> getTStSkills() {
		return this.TStSkills;
	}

	public void setTStSkills(Set<Skill> TStSkills) {
		this.TStSkills = TStSkills;
	}

	public Team getTStTeam() {
		return this.TStTeam;
	}

	public void setTStTeam(Team TStTeam) {
		this.TStTeam = TStTeam;
	}

}