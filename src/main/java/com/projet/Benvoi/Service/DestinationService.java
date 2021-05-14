package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.projet.Benvoi.Model.Destination;
import com.projet.Benvoi.Repository.DestinationRepository;

@Service
@Transactional
public class DestinationService {
	@Autowired
	DestinationRepository repository;
	public List<Destination> getAll(){
		return repository.findAll(Sort.by("libelle").ascending());
		
	}
	public int max() {
	return repository.max();	
	}
	public int nbre() {
		return repository.nbre();
	}
	
public Optional<Destination> findByCode(String code){
	return repository.findByCode(code);
	}
public long save(Destination Destination) {
	Destination dest =new Destination();
	dest.setCode(Destination.getCode());
	dest.setLibelle(Destination.getLibelle());
	return repository.save(dest).getId();
}
 public void update(String code ,Destination Destination) {
	 Optional<Destination> des= repository.findByCode(code);
	 if (des.isPresent()) {
		  Destination dest=des.get();
		 dest.setLibelle(Destination.getLibelle());
		 repository.save(dest);
	 }
	 
 }
 public List<Destination> findByLibelle(String libelle){
	return repository.findAllByLibelleContaining(libelle);
	 
 }
 
 public void delete(String code) {
	 Optional<Destination> des= repository.findByCode(code);
	des.ifPresent(repository::delete);
 }
}