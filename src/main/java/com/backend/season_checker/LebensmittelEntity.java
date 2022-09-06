package com.backend.season_checker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "lebensmittel")
public class LebensmittelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String anfangsDatum;
	private String endDatum;
	private boolean isFavorit;

	public LebensmittelEntity() {

	}

	public LebensmittelEntity(String name, String anfangsDatum, String endDatum, boolean isFavorit) {
		this.name = name;
		this.anfangsDatum = anfangsDatum;
		this.endDatum = endDatum;
		this.isFavorit = isFavorit;
	}

	public String getAnfangsDatum() {
		return anfangsDatum;
	}

	public String getEndDatum() {
		return endDatum;
	}

	public boolean isFavorit() {
		return isFavorit;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}