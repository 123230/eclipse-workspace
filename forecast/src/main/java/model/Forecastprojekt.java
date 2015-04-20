package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "T_FP" database table.
 * 
 */
@Entity
@Table(name="\"T_FP\"")
@NamedQuery(name="Forecastprojekt.findAll", query="SELECT f FROM Forecastprojekt f")
public class Forecastprojekt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="'T_FP'_ID_GENERATOR", sequenceName="T_FORECASTPROJEKT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="'T_FP'_ID_GENERATOR")
	@Column(name="\"ID\"", unique=true, nullable=false)
	private Integer id;

	@Column(name="\"AUFTRAGSSTATUS\"", length=10)
	private String auftragsstatus;

	@Column(name="\"NAME\"", length=50)
	private String name;

	//bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinColumns({
		})
	private Set<Skill> TStSkills;

	//bi-directional many-to-many association to Milesprojekt
	@ManyToMany
	@JoinColumns({
		})
	private Set<Milesprojekt> TMps;

	//bi-directional many-to-many association to Team
	@ManyToMany(mappedBy="TFps")
	private Set<Team> TStTeams;

	public Forecastprojekt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuftragsstatus() {
		return this.auftragsstatus;
	}

	public void setAuftragsstatus(String auftragsstatus) {
		this.auftragsstatus = auftragsstatus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Skill> getTStSkills() {
		return this.TStSkills;
	}

	public void setTStSkills(Set<Skill> TStSkills) {
		this.TStSkills = TStSkills;
	}

	public Set<Milesprojekt> getTMps() {
		return this.TMps;
	}

	public void setTMps(Set<Milesprojekt> TMps) {
		this.TMps = TMps;
	}

	public Set<Team> getTStTeams() {
		return this.TStTeams;
	}

	public void setTStTeams(Set<Team> TStTeams) {
		this.TStTeams = TStTeams;
	}

}