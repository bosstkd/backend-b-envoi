package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projet.Benvoi.Repository.GradeRepository;

import com.projet.Benvoi.Model.Grade;


import javax.transaction.Transactional;
import org.springframework.data.domain.Sort;
@Service
@Transactional
public class GradeService {
	@Autowired
	GradeRepository repository;
 
	public List<Grade> getAll() {
		System.out.println("Get all Gradees 11111...");
    	return repository.findAll(Sort.by("libelle").ascending());	    	
    }
	
	
	
    public Optional<Grade> findByCode(String code) {
        return repository.findByCode(code);
    }
    
    public long save(Grade grade) {
    	
        
        return repository.save(grade)
                             .getId();
    }
    public void update(long id, Grade grade) {
        Optional<Grade> grad = repository.findById(id);
        if (grad.isPresent()) {
            Grade gra = grad.get();
            gra.setLibelle(grade.getLibelle());
           
            
            repository.save(gra);
        }
    }
  

    public List<Grade> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }

    public void delete(long id) {
        Optional<Grade> gra = repository.findById(id);
        gra.ifPresent(repository::delete);
    }

	public Optional<Grade> findById(Long id) {
		
		return repository.findById(id);
	}



	
	

}
