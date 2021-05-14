package com.projet.Benvoi.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "compteur")
public class Compteur {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	private int annee;
	private int numdepot;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNumdepot() {
		return numdepot;
	}
	public void setNumdepot(int numdepot) {
		this.numdepot = numdepot;
	}
	@Override
	public String toString() {
		return "Compteur [id=" + id + ", annee=" + annee + ", numdepot=" + numdepot + "]";
	}
	public Compteur(long id, int annee, int numdepot) {
		super();
		this.id = id;
		this.annee = annee;
		this.numdepot = numdepot;
	}
	public Compteur() {
		super();
	}
	
	
}
