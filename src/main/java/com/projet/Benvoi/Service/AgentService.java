package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.Benvoi.Dto.ListAgent;
import com.projet.Benvoi.Model.Agent;
import com.projet.Benvoi.Repository.AgentRepository;

@Service
@Transactional
public class AgentService {
	 @Autowired
		AgentRepository repository;
	 public List<ListAgent> getAll() {
	    	return repository.listAgent();	    	
	    }

		

		public int nbre(int mat) {
			return repository.nbre(mat);
		}



		public int max(int mat) {
			return repository.max(mat);
		}
		
	    public Optional<Agent> findByMat(int mat) {
	        return repository.findByMat(mat);
	    }
	    
	    public long save(Agent Agent) {
	    	
	        return repository.save(Agent)
	                             .getId();
	    }

public Optional<Agent> findById(long id){
	return repository.findById(id);
	}
	    public void update(long id, Agent Agent) {
	        Optional<Agent> ags = repository.findById(id);
	        if (ags.isPresent()) {
	            Agent ag = ags.get();
	            ag.setNom(Agent.getNom());  
	            repository.save(ag);
	        }
	    }

	    public void delete(long id){
	        Optional<Agent> ag = repository.findById(id);
	       ag.ifPresent(repository::delete);
	    }
		  public List<Agent> findByCodeg(String code) {
		        return repository.findAllByCodeg(code);
		    }
		  public List<Agent> findByCodres(String code) {
		        return repository.findAllByCodres(code);
		    }

		
}
