package com.projet.Benvoi.Dto;

public class ListAgence {
	private String code;
	private String libelle;
	private String libdir;
	private String codedir;
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
	public String getLibdir() {
		return libdir;
	}
	public void setLibdir(String libdir) {
		this.libdir = libdir;
	}
	public String getCodedir() {
		return codedir;
	}
	public void setCodedir(String codedir) {
		this.codedir = codedir;
	}
	public ListAgence(String code, String libelle, String libdir, String codedir) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.libdir = libdir;
		this.codedir = codedir;
	}
	public ListAgence() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ListDirection [code=" + code + ", libelle=" + libelle + ", libdir=" + libdir + ", codedir=" + codedir
				+ "]";
	}

}
