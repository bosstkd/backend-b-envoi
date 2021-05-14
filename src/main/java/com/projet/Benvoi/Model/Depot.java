package com.projet.Benvoi.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "depot")
public class Depot {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int annee;
	  private int numero;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date date_depot;
	  private int mat;
	  private String sms;
	  private String code;
	
	  private String destinataire;
	  private double total;
	  @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "depot", fetch=FetchType.EAGER)
    @Valid
	  private List<Ldepot> ldepots = new ArrayList<>();
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
	public String getCode() {
		return code;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}
	
	/*public int getNbre() {
		return nbre;
	}
	public void setNbre(int nbre) {
		this.nbre = nbre;
	}*/

	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<Ldepot> getLdepots() {
		return ldepots;
	}
	public void setLdepots(List<Ldepot> ldepots) {
		this.ldepots = ldepots;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}


	public Depot(long id, int annee, int numero, Date date_depot, int mat, String sms, String code, 
			String destinataire, double total, @Valid List<Ldepot> ldepots) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.date_depot = date_depot;
		this.mat = mat;
		this.sms = sms;
		this.code = code;
		
		this.destinataire = destinataire;
		this.total = total;
		this.ldepots = ldepots;
	}
	public Depot() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Depot [id=" + id + ", annee=" + annee + ", numero=" + numero + ", date_depot=" + date_depot + ", mat="
				+ mat + ", sms=" + sms + ", code=" + code  + ", destinataire="
				+ destinataire + ", total=" + total + ", ldepots=" + ldepots + "]";
	}
	
	
	 
}
