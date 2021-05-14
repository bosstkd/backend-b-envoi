package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet.Benvoi.Model.TypeCourrier;
import com.projet.Benvoi.Repository.TypeCourrierRepository;

@Service
@Transactional
public class TypeCourrierService {
	@Autowired
	TypeCourrierRepository repository;
	public List<TypeCourrier> getAll(){
		return repository.findAll(Sort.by("libelle").ascending());
		
	}
	public int max() {
	return repository.max();	
	}
	public int nbre() {
		return repository.nbre();
	}
	
public Optional<TypeCourrier> findByCode(String code){
	return repository.findByCode(code);
	}
public long save(TypeCourrier TypeCourrier) {
	TypeCourrier cour =new TypeCourrier();
	cour.setCode(TypeCourrier.getCode());
	cour.setLibelle(TypeCourrier.getLibelle());
	return repository.save(cour).getId();
}
 public void update(String code ,TypeCourrier TypeCourrier) {
	 Optional<TypeCourrier> des= repository.findByCode(code);
	 if (des.isPresent()) {
		 TypeCourrier cour=des.get();
		 cour.setLibelle(TypeCourrier.getLibelle());
		 repository.save(cour);
	 }
	 
 }
 public List<TypeCourrier> findByLibelle(String libelle){
	return repository.findAllByLibelleContaining(libelle);
	 
 }
 
 public void delete(String code) {
	 Optional<TypeCourrier> des= repository.findByCode(code);
	des.ifPresent(repository::delete);
 }
}