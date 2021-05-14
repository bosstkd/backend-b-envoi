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
@Table(name = "ltarif")
public class Ltarif {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 private String code;
	 private double deb;
	 private double fin;
	 private double montant;
	 @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Tarif tarif;
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
	public double getDeb() {
		return deb;
	}
	public void setDeb(double deb) {
		this.deb = deb;
	}
	public double getFin() {
		return fin;
	}
	public void setFin(double fin) {
		this.fin = fin;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public Tarif getTarif() {
		return tarif;
	}
	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}
	public Ltarif(long id, String code, double deb, double fin, double montant, Tarif tarif) {
		super();
		this.id = id;
		this.code = code;
		this.deb = deb;
		this.fin = fin;
		this.montant = montant;
		this.tarif = tarif;
	}
	public Ltarif() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ltarif [id=" + id + ", code=" + code + ", deb=" + deb + ", fin=" + fin + ", montant=" + montant
				+  ", tarif=" + tarif + "]";
	}
	


	
}