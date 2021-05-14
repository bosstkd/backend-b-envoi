package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.Benvoi.Dto.ListTarif;
//import com.projet.Benvoi.Model.Agent;
//import com.projet.Benvoi.Model.Categorie;

import com.projet.Benvoi.Model.Ltarif;
import com.projet.Benvoi.Model.Tarif;
//import com.projet.Benvoi.Repository.DestinationRepository;
import com.projet.Benvoi.Repository.LtarifRepository;
import com.projet.Benvoi.Repository.TarifRepository;
//import com.projet.Benvoi.domaine.Message;

@Service
@Transactional
public class TarifService {
	@Autowired TarifRepository repository;
	@Autowired LtarifRepository Lrepository;
	public List<ListTarif> getAll() {
		System.out.println("Get all Tarif 11111...");
    	return repository.listTarif();	    	
    }
	
	public int nbre () {
		return repository.nbre();
	}



	public int max() {
		return repository.max();
	}
	
	  public Optional<Tarif> findByCode(String code) {
	        return repository.findByCode(code);
	    }

	  
		public Optional<Tarif> findById(String code) {
			 return repository.findByCode(code);
		}
		public Iterable<Tarif> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		   public void  save(@Valid @RequestBody Tarif Tarif) {
			   System.out.println("save ltarif");
			   List<Ltarif> ltarifs = Tarif.getLtarifs();
			   System.out.println(Tarif);
			   for (Ltarif ltarif : ltarifs) {
			    	 System.out.println(Tarif.getCode());
			    	
		            ltarif.setCode(Tarif.getCode());
		           System.out.println(" save data ligne");
		          	Lrepository.save(ltarif);
			       }	
			   repository.save(Tarif);
		    }
		
		  
	
		   public void update(String code, Tarif tarif) {
			   Optional<Tarif> tar = repository.findByCode(code);
		        if (tar.isPresent()) {
		           Tarif tari = tar.get();
		          
		            tari.setCode(tarif.getCode());
		            
		            repository.save(tari);
		        } 
		    }	
			
		
		public List<Tarif> findAllByCode(String code) {
		
			return  repository.findAllByCode(code);
		}
		
		public void delete(String code) {
			// TODO Auto-generated method stub
			 Optional<Tarif> cat = repository.findByCode(code);
		        cat.ifPresent(repository::delete);
		    }
		  public List<Tarif> findByTypecourrier(String code) {
		        return repository.findAllByTypecourrier(code);
		    }
		  public List<Tarif> findByCodedes(String code) {
		        return repository.findAllByCodedes(code);
		    }
		}
		
		

