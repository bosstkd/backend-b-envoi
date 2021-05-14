package com.projet.Benvoi.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListDepot {
	 private long id;
	  private int annee;
	  private int numero;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date date_depot;
	  private int mat;
	  private String sms;
	  private String code;
	  private String destinataire;
	  private String designation;
	  private String destination;
	  private double poids;
	  private double montant;
	  private double total;
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
	public Date getDate_depot() {
		return date_depot;
	}
	public void setDate_depot(Date date_depot) {
		this.date_depot = date_depot;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
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
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ListDepot(long id, int annee, int numero, Date date_depot, int mat, String sms, String code,
			String destinataire, String designation, String destination, double poids, double montant, double total) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.date_depot = date_depot;
		this.mat = mat;
		this.sms = sms;
		this.code = code;
		this.destinataire = destinataire;
		this.designation = designation;
		this.destination = destination;
		this.poids = poids;
		this.montant = montant;
		this.total = total;
	}

}
