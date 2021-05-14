package com.projet.Benvoi.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "parametre")

public class Parametre {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	 private String code;
	  private String libelle;
	  private int numc;
	  private int numa;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getNumc() {
		return numc;
	}
	public void setNumc(int numc) {
		this.numc = numc;
	}
	
	
	public int getNuma() {
		return numa;
	}
	public void setNuma(int numa) {
		this.numa = numa;
	}
	@Override
	public String toString() {
		return "Parametre [id=" + id + ", code=" + code + ", libelle=" + libelle + ", numc=" + numc + ", numa=" + numa
				+ "]";
	}
	public Parametre(long id, String code, String libelle, int numc, int numa) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.numc = numc;
		this.numa = numa;
	}
	public Parametre() {
		super();
	}
	
	
}
