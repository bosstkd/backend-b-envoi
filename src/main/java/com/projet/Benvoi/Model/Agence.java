package com.projet.Benvoi.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "agence")
public class Agence {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	  private String code;
	  private String codedir;
	  private String libelle;
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
	public String getCodedir() {
		return codedir;
	}
	public void setCodedir(String codedir) {
		this.codedir = codedir;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Agence(long id, String code, String codedir, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.codedir = codedir;
		this.libelle = libelle;
	}
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Agence [id=" + id + ", code=" + code + ", codedir=" + codedir + ", libelle=" + libelle + "]";
	}


	
}
