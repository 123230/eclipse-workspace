package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "T_MP" database table.
 * 
 */
@Entity
@Table(name="\"T_MP\"")
@NamedQuery(name="Milesprojekt.findAll", query="SELECT m FROM Milesprojekt m")
public class Milesprojekt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"ID\"", unique=true, nullable=false, length=20)
	private String id;

	@Column(name="\"IST-ZEIT\"")
	private Integer ist_zeit;

	@Column(name="\"KOSTENSTELLE\"", length=20)
	private String kostenstelle;

	@Column(name="\"NAME\"", length=100)
	private String name;

	//bi-directional many-to-many association to Forecastprojekt
	@ManyToMany(mappedBy="TMps")
	private Set<Forecastprojekt> TFps;

	public Milesprojekt() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIst_zeit() {
		return this.ist_zeit;
	}

	public void setIst_zeit(Integer ist_zeit) {
		this.ist_zeit = ist_zeit;
	}

	public String getKostenstelle() {
		return this.kostenstelle;
	}

	public void setKostenstelle(String kostenstelle) {
		this.kostenstelle = kostenstelle;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Forecastprojekt> getTFps() {
		return this.TFps;
	}

	public void setTFps(Set<Forecastprojekt> TFps) {
		this.TFps = TFps;
	}

}