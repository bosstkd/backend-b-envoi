package com.projet.Benvoi.Dto;

public class ListTarif {
	private String code;
	private String typecourrier;
	private String codedes;
	private String libtypecourrier;
	private String libcodedes;
	private double deb;
	private double fin;
	private double montant;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTypecourrier() {
		return typecourrier;
	}
	public void setTypecourrier(String typecourrier) {
		this.typecourrier = typecourrier;
	}
	public String getCodedes() {
		return codedes;
	}
	public void setCodedes(String codedes) {
		this.codedes = codedes;
	}
	public String getLibtypecourrier() {
		return libtypecourrier;
	}
	public void setLibtypecourrier(String libtypecourrier) {
		this.libtypecourrier = libtypecourrier;
	}
	public String getLibcodedes() {
		return libcodedes;
	}
	public void setLibcodedes(String libcodedes) {
		this.libcodedes = libcodedes;
	}
	public double getDeb() {
		return deb;
	}
	public void setDeb(double deb) {
		this.deb = deb;
	}
	public ListTarif(String code, String typecourrier, String codedes, String libtypecourrier, String libcodedes,
			double deb, double fin, double montant) {
		super();
		this.code = code;
		this.typecourrier = typecourrier;
		this.codedes = codedes;
		this.libtypecourrier = libtypecourrier;
		this.libcodedes = libcodedes;
		this.deb = deb;
		this.fin = fin;
		this.montant = montant;
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
	

	
	


}
