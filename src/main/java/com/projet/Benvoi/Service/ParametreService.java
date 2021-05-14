package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet.Benvoi.Model.Parametre;
import com.projet.Benvoi.Repository.ParametreRepository;

@Service
@Transactional
public class ParametreService {
	@Autowired
	ParametreRepository repository;
	
	public List<Parametre> getAll(){
		return repository.findAll(Sort.by("libelle").ascending());
		
	}
	 
public Optional<Parametre> findByCode(String code){
	return repository.findByCode(code);
	}

public Parametre createParametre(Parametre parametre) {	
	return repository.save(parametre);
}
 public void update(String code ,Parametre parametre) {
	 Optional<Parametre> categ= repository.findByCode(code);
	 if (categ.isPresent()) {
		 Parametre par=categ.get();
		 par.setLibelle(parametre.getLibelle());;
			par.setNumc(parametre.getNumc());
		 repository.save(par);
	 }
	 
 }
 public List<Parametre> findByLibelle(String libelle){
	return repository.findAllByLibelleContaining(libelle);
	 
 }
 
 public void delete(String code) {
	 Optional<Parametre> categ= repository.findByCode(code);
	 categ.ifPresent(repository::delete);
 }





public Optional<Parametre> findById(long id) {
	return repository.findById(id);
}
}
