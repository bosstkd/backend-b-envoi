package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.projet.Benvoi.Model.Depot;
import com.projet.Benvoi.Model.Ldepot;
//import com.projet.Benvoi.Repository.DepotRepository;
import com.projet.Benvoi.Repository.LdepotRepository;

@Service
@Transactional

public class LdepotService {
	@Autowired 	LdepotRepository ldepotrepo;
	public List<Ldepot> getAll() {
		System.out.println("Get all Ldepots 11111...");
    	return ldepotrepo.findAll(Sort.by("numero").ascending());	    	
    }
	   public Optional<Ldepot> findByCode(String code) {
	        return  ldepotrepo.findByCode(code);
	    }
	    
	    public long save(Ldepot ldepot) {
	    	
	        return  ldepotrepo.save(ldepot)
	                             .getId();
	    }
	    
	
	    public List<Ldepot> findByLibelle(String libelle) {
	        return ldepotrepo.findAllByDesignationContaining(libelle);
	    }

	    public void delete(long id) {
	        Optional<Ldepot> dep = ldepotrepo.findById(id);
	       dep.ifPresent(ldepotrepo::delete);
	    }
		public void update(long id, Ldepot ldepot) {
			 Optional<Ldepot> ldepo = ldepotrepo.findById(id);
		        if (ldepo.isPresent()) {
		           Ldepot ldep =ldepo.get();
		          
		            ldep.setCode(ldepot.getCode());
		            ldep.setNumero(ldepot.getNumero());
		            ldep.setAnnee(ldepot.getAnnee());
		           
		            
		            ldepotrepo.save(ldep);
		        }
		    }
		public Optional<Ldepot> findById(long id) {
			// TODO Auto-generated method stub
			return ldepotrepo.findById(id);
		}
		
}



