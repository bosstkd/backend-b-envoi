package com.projet.Benvoi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projet.Benvoi.Dto.ListAgent;
import com.projet.Benvoi.Model.Agent;
import com.projet.Benvoi.Service.AgentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AgentController {
	 @Autowired
	    private AgentService agService;
	 
	 @GetMapping("/agents/7/{mat}")
	 public  int getMat(@PathVariable int mat) {
		 System.out.println("Get Numbers...");
		 int  x = agService.nbre(mat);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return agService.max(mat);
		 }
	 }
	 
	 @GetMapping("/agents")
	    public List<ListAgent> list() {
         return agService.getAll();
}

	 @GetMapping("/agents/{id}")
	 public ResponseEntity<Agent> post(@PathVariable long id) {
	        Optional<Agent> ag = agService.findById(id);
	        return ag.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
	                                              .build());
	    }
	    
	    
	 @PostMapping("/agents")
	    public long save(@RequestBody Agent Agent) {
		 
	        return agService.save(Agent);
	    }

	 @PutMapping("/agents/{id}")
	    public void update(@PathVariable long id, @RequestBody Agent Agent) {
	        Optional<Agent> ags = agService.findById(id);
	        if (ags.isPresent()) {
	            agService.update(id, Agent);
	        } else {
	            agService.save(Agent);
	        }
	    }

	  @DeleteMapping("/agents/{id}")
	    public void delete(@PathVariable long id) {
	        agService.delete(id);
	    }
	     
}
