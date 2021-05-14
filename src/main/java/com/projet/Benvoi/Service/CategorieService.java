package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet.Benvoi.Model.Categorie;
import com.projet.Benvoi.Repository.CategorieRepository;

@Service
@Transactional
public class CategorieService {
	@Autowired
	CategorieRepository repository;
	public List<Categorie> getAll(){
		return repository.findAll(Sort.by("libelle").ascending());
		
	}
	public int max() {
	return repository.max();	
	}
	public int nbre() {
		return repository.nbre();
	}
	
public Optional<Categorie> findByCode(String code){
	return repository.findByCode(code);
	}
public long save(Categorie categorie) {
	Categorie cat =new Categorie();
	cat.setCode(categorie.getCode());
	cat.setLibelle(categorie.getLibelle());
	return repository.save(cat).getId();
}
 public void update(String code ,Categorie categorie) {
	 Optional<Categorie> categ= repository.findByCode(code);
	 if (categ.isPresent()) {
		 Categorie cat=categ.get();
		 cat.setLibelle(categorie.getLibelle());
		 repository.save(cat);
	 }
	 
 }
 public List<Categorie> findByLibelle(String libelle){
	return repository.findAllByLibelleContaining(libelle);
	 
 }
 
 public void delete(String code) {
	 Optional<Categorie> categ= repository.findByCode(code);
	 categ.ifPresent(repository::delete);
 }
}