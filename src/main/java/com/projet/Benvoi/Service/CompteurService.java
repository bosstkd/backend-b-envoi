package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet.Benvoi.Model.Compteur;
import com.projet.Benvoi.Repository.CompteurRepository;


@Service
@Transactional
public class CompteurService {
	@Autowired
	CompteurRepository repository;
	
	 public List<Compteur> getAll() {
			System.out.println("Get all Compteurs ...");
	    	return repository.findAll(Sort.by("annee").ascending());	    	
	    }
	
	
	 public Optional<Compteur> findById(long id) {
	        return repository.findById(id);
	    }
	
	    
public long save(Compteur Compteur) {
	
	
	return repository.save(Compteur).getId();
}
 public void update(long id ,Compteur Compteur) {
	 Optional<Compteur> des= repository.findById(id);
	 if (des.isPresent()) {
		 Compteur Compt=des.get();
		 Compt.setAnnee(Compteur.getAnnee());
		 repository.save(Compt);
	 }
	 
 }

 
 public void delete(long id) {
	 Optional<Compteur> des= repository.findById(id);
	des.ifPresent(repository::delete);
 }


public Optional<Compteur> findByAnnee(int annee) {
	 return repository.findByAnnee(annee);
}

}
