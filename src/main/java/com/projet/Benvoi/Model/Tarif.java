package com.projet.Benvoi.Model;

//import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tarif")
public class Tarif {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String code;
	private String typecourrier;
	private String codedes;
	 @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "tarif", fetch=FetchType.EAGER)
     @Valid
	  private List<Ltarif> ltarifs = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCodedes() {
		return codedes;
	}
	public void setCodedes(String codedes) {
		this.codedes = codedes;
	}
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
	public List<Ltarif> getLtarifs() {
		return ltarifs;
	}
	public void setLtarifs(List<Ltarif> ltarifs) {
		this.ltarifs = ltarifs;
	}
	public Tarif(long id, String code, String typecourrier, String codedes, @Valid List<Ltarif> ltarifs) {
		super();
		this.id = id;
		this.code = code;
		this.typecourrier = typecourrier;
		this.codedes = codedes;
		this.ltarifs = ltarifs;
	}
	public Tarif() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tarif [id=" + id + ", code=" + code + ", typecourrier=" + typecourrier + ", codedes=" + codedes
				+ ", ltarifs=" + ltarifs + "]";
	}
	
	
	
}