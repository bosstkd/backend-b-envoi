package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet.Benvoi.Model.Cposte;
import com.projet.Benvoi.Repository.CposteRepository;

@Service
@Transactional
public class CposteService {
	 @Autowired CposteRepository cposterepo;
	 public List<Cposte> getAll() {
			System.out.println("Get all Cpostes 11111...");
	    	return cposterepo.findAll(Sort.by("annee").ascending());	    	
	    }
	 public Optional<Cposte> findById(long id) {
	        return cposterepo.findById(id);
	    }
	    
	    public long save(Cposte cposte) {
	    	
	        return cposterepo.save(cposte)
	                             .getId();
	    }
	    public void update(long id, Cposte cposte) {
	        Optional<Cposte> cpos = cposterepo.findById(id);
	        if (cpos.isPresent()) {
	            Cposte cp = cpos.get();
	            cp.setCode_dir(cposte.getCode_dir());
	            cp.setAnnee(cposte.getAnnee());
	            cposterepo.save(cp);
	        }
	    }
	    public void delete(long id) {
	        Optional<Cposte> cpo =  cposterepo.findById(id);
	        cpo.ifPresent(  cposterepo::delete);
	    }
		
	  
}


