package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "T_ST_KOST" database table.
 * 
 */
@Entity
@Table(name="\"T_ST_KOST\"")
@NamedQuery(name="Kosten.findAll", query="SELECT k FROM Kosten k")
public class Kosten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="'T_ST_KOST'_ID_GENERATOR", sequenceName="T_KOSTENSATZ_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="'T_ST_KOST'_ID_GENERATOR")
	@Column(name="\"ID\"", unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="\"BIS\"")
	private Date bis;

	@Column(name="\"KOSTENSATZ\"")
	private double kostensatz;

	@Column(name="\"SID-SKILL\"", length=30)
	private String sid_skill;

	@Temporal(TemporalType.DATE)
	@Column(name="\"VON\"")
	private Date von;

	//bi-directional many-to-one association to Skill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private Skill TStSkill;

	public Kosten() {
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

	public double getKostensatz() {
		return this.kostensatz;
	}

	public void setKostensatz(double kostensatz) {
		this.kostensatz = kostensatz;
	}

	public String getSid_skill() {
		return this.sid_skill;
	}

	public void setSid_skill(String sid_skill) {
		this.sid_skill = sid_skill;
	}

	public Date getVon() {
		return this.von;
	}

	public void setVon(Date von) {
		this.von = von;
	}

	public Skill getTStSkill() {
		return this.TStSkill;
	}

	public void setTStSkill(Skill TStSkill) {
		this.TStSkill = TStSkill;
	}

}