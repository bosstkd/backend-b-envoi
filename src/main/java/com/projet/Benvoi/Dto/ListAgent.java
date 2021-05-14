package com.projet.Benvoi.Dto;

public class ListAgent {
	private long id;
	  private int mat;
	  private String nom;
	  private String libgrade;
	  private String libres;
	  private String libdir;
	  private String codeg;
	  private String coded;
	  private String coder;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLibgrade() {
		return libgrade;
	}
	public void setLibgrade(String libgrade) {
		this.libgrade = libgrade;
	}
	public String getLibres() {
		return libres;
	}
	public void setLibres(String libres) {
		this.libres = libres;
	}
	public String getLibdir() {
		return libdir;
	}
	public void setLibdir(String libdir) {
		this.libdir = libdir;
	}
	public String getCodeg() {
		return codeg;
	}
	public void setCodeg(String codeg) {
		this.codeg = codeg;
	}
	public String getCoded() {
		return coded;
	}
	public void setCoded(String coded) {
		this.coded = coded;
	}
	public String getCoder() {
		return coder;
	}
	public void setCoder(String coder) {
		this.coder = coder;
	}
	public ListAgent(long id, int mat, String nom, String libgrade, String libres, String libdir, String codeg,
			String coded, String coder) {
		super();
		this.id = id;
		this.mat = mat;
		this.nom = nom;
		this.libgrade = libgrade;
		this.libres = libres;
		this.libdir = libdir;
		this.codeg = codeg;
		this.coded = coded;
		this.coder = coder;
	}
	
	
	
	 
}
