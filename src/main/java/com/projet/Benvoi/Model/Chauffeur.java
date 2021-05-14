package com.projet.Benvoi.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chauffeur")
public class Chauffeur {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String mat;
	  private String nom;
	  private String libelle;
	  private String grade;
	  private String destination;
	  private String tel;
	  private String agence;
	  private String direction;
	  private String email;
	  private String login;
	  private String pwd;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Chauffeur [id=" + id + ", mat=" + mat + ", nom=" + nom + ", libelle=" + libelle + ", grade=" + grade
				+ ", destination=" + destination + ", tel=" + tel + ", agence=" + agence + ", direction=" + direction
				+ ", email=" + email + ", login=" + login + ", pwd=" + pwd + "]";
	}
	public Chauffeur(long id, String mat, String nom, String libelle, String grade, String destination, String tel,
			String agence, String direction, String email, String login, String pwd) {
		super();
		this.id = id;
		this.mat = mat;
		this.nom = nom;
		this.libelle = libelle;
		this.grade = grade;
		this.destination = destination;
		this.tel = tel;
		this.agence = agence;
		this.direction = direction;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
	}
	public Chauffeur() {
		super();
	}
	
	  
	  
}