package com.projet.Benvoi.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	  private int mat;
	  private String nom;
	  private String codeg;
	  private String codres;
	  //codres=codeAgence
	  //private String codedir;
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
	public String getCodeg() {
		return codeg;
	}
	public void setCodeg(String codeg) {
		this.codeg = codeg;
	}
	public String getCodres() {
		return codres;
	}
	public void setCodres(String codres) {
		this.codres = codres;
	}
	/*public String getCodedir() {
		return codedir;
	}
	public void setCodedir(String codedir) {
		this.codedir = codedir;
	}*/
	@Override
	public String toString() {
		return "Agent [id=" + id + ", mat=" + mat + ", nom=" + nom + ", codeg=" + codeg + ", codres=" + codres
				+// ", codedir=" + codedir + 
				"]";
	}
	public Agent(long id, int mat, String nom, String codeg, String codres//, String codedir
			
			) {
		super();
		this.id = id;
		this.mat = mat;
		this.nom = nom;
		this.codeg = codeg;
		this.codres = codres;
		//this.codedir = codedir;
	}
	public Agent() {
		super();
	}

	  
}
