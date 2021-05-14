package com.projet.Benvoi.Dto;

public class ListArticle {
	 private String code;
	 private String libelle;
	 private String categ;
	 private double pa;
	 private double pv;
	 private int tva;
	 private int stock;
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
	
	public String getCateg() {
		return categ;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}
	public double getPa() {
		return pa;
	}
	public void setPa(double pa) {
		this.pa = pa;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public ListArticle(String code, String libelle,  String categ, double pa, double pv, int tva,
			int stock) {
		super();
		this.code = code;
		this.libelle = libelle;
		
		this.categ = categ;
		this.pa = pa;
		this.pv = pv;
		this.tva = tva;
		this.stock = stock;
	}
	
	

	


}
