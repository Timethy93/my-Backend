package com.backend.season_checker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "lebensmittel") // This tells Hibernate to make a table out of this class
public class LebensmittelEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String anfangsDatum;
  private String endDatum;
  private boolean isFavorit;

  public String getAnfangsDatum() {
    return anfangsDatum;
  }

  public void setAnfangsDatum(String anfangsDatum) {
    this.anfangsDatum = anfangsDatum;
  }

  public String getEndDatum() {
    return endDatum;
  }

  public void setEndDatum(String endDatum) {
    this.endDatum = endDatum;
  }

  public boolean isFavorit() {
    return isFavorit;
  }

  public void setFavorit(boolean isFavorit) {
    this.isFavorit = isFavorit;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}