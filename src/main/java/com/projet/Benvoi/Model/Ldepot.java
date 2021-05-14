package com.projet.Benvoi.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "ldepot")
public class Ldepot {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int annee;
	  private int numero;
      private int num;
	 
	  private String code;
	  private double poids;
	
	  private double montant;
	  private String designation;
	  private String destination;
	  @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Depot depot;
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Ldepot(long id, int annee, int numero, int num, String code, double poids, double montant, String designation,
			String destination, Depot depot) {
		
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.num = num;
		this.code = code;
		this.poids = poids;
		this.montant = montant;
		this.designation = designation;
		this.destination = destination;
		this.depot = depot;
	}
	public Ldepot() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ldepot [id=" + id + ", annee=" + annee + ", numero=" + numero + ", num=" + num + ", code=" + code
				+ ", poids=" + poids + ", montant=" + montant + ", designation=" + designation + ", destination="
				+ destination + ", depot=" + depot + "]";
	}	
	
}