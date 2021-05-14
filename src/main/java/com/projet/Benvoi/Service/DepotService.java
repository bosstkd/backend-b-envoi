package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.Benvoi.Model.Depot;
import com.projet.Benvoi.Model.Ldepot;
//import com.projet.Benvoi.Model.Ltarif;
//import com.projet.Benvoi.Model.Tarif;
import com.projet.Benvoi.Repository.DepotRepository;
import com.projet.Benvoi.Repository.LdepotRepository;

@Service
@Transactional
public class DepotService {
	@Autowired DepotRepository depotrepo;
	@Autowired LdepotRepository ldepotrepo;
	public List<Depot> getAll() {
		System.out.println("Get all Depots 11111...");
    	return depotrepo.findAll(Sort.by("numero").ascending());	    	
    }
	  
	    
	   public void  save(@Valid @RequestBody Depot Depot) {
		   System.out.println("save ldepot");
		   List<Ldepot> ldepots = Depot.getLdepots();
		   System.out.println(Depot);
		   for (Ldepot ldepot : ldepots) {
		    	 System.out.println(Depot.getCode());
	            ldepot.setCode(Depot.getCode());
	           
	           
	           System.out.println(" save data ligne");
	           ldepotrepo.save(ldepot);
		       }
		   	
		   depotrepo.save(Depot);
	    }
	    public void update(long id, Depot depot) {
	        Optional<Depot> depo = depotrepo.findById(id);
	        if (depo.isPresent()) {
	           Depot dep =depo.get();
	          
	            dep.setCode(depot.getCode());
	            dep.setNumero(depot.getNumero());
	            dep.setAnnee(depot.getAnnee());
	            dep.setDate_depot(depot.getDate_depot());
	           
	            dep.setTotal(depot.getTotal());
	            
	            depotrepo.save(dep);
	        }
	    }
	  
	
	 

	    public void delete(long id) {
	        Optional<Depot> dep = depotrepo.findById(id);
	       dep.ifPresent(depotrepo::delete);
	    }
		public Optional<Depot> findById(long id) {
			// TODO Auto-generated method stub
			return depotrepo.findById(id);
		}
		public List<Depot> findAllByCode(String code) {
			// TODO Auto-generated method stub
			return depotrepo.findAllByCode(code);
		}
		
		
		
}


