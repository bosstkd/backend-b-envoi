package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.rapide.projet.Dto.ListCategorie;
import com.projet.Benvoi.Dto.ListAgence;
import com.projet.Benvoi.Model.Agence;
//import com.rapide.projet.Model.Scategorie;
import com.projet.Benvoi.Repository.AgenceRepository;

@Service
@Transactional
public class AgenceService {
	 @Autowired AgenceRepository agenrep;
		public List<ListAgence> getAll() {
			System.out.println("Get all  agences...");
	    	return  agenrep.listAgence();	 
	    	 
	    }
		
		
	    public Optional<Agence> findByCode(String code) {
	        return agenrep.findByCode(code);
	    }
	    public Optional<Agence> findById(long id) {
	        return agenrep.findById(id);
	    }
	   
	    public long save(Agence Agence) {
	    	
	        return agenrep.save(Agence)
	                             .getId();
	    }
	    public void update(String code, Agence Agence) {
	        Optional<Agence> dire =agenrep.findByCode(code);
	        if (dire.isPresent()) {
	            Agence dii = dire.get();
		        dii.setLibelle(Agence.getLibelle());
		      
	           agenrep.save(dii);
	        }
	    }
	  
	    public List<Agence> findByCodedir(String code) {
	        return agenrep.findAllByCodedir(code);
	    }
	    public List<Agence> findByLibelle(String libelle) {
	        return agenrep.findAllByLibelleContaining(libelle);
	    }

	    public void delete(String code) {
	        Optional<Agence> cat =agenrep.findByCode(code);
	        cat.ifPresent(agenrep::delete);
	    }

		public int nbre(String code) {
			return agenrep.nbre(code);
		}



		public int max(String code) {
			return agenrep.max(code);
		}

}





