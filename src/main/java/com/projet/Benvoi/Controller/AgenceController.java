package com.projet.Benvoi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import com.projet.Benvoi.Dto.ListAgence;
import com.projet.Benvoi.Model.Agence;
//import com.projet.Benvoi.Model.Direction;
//import com.rapide.projet.Model.Scategorie;
import com.projet.Benvoi.Service.AgenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AgenceController {
	 @Autowired
	    private AgenceService agencserv;
	 @GetMapping("/agences/7/{code}")
	 public  int getCode(@PathVariable String code) {
		 System.out.println("Get Numbers...");
		 int  x = agencserv.nbre(code);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return agencserv.max(code);
		 }
	 }
	 

	 @GetMapping("/agences")
	    public List<ListAgence> list() {
		 System.out.println("Get all directions...");
	             return agencserv.getAll();
	   }
	 @GetMapping("/agences/{id}")
	 public ResponseEntity<Agence> post(@PathVariable String id) {
	        Optional<Agence> cat = agencserv.findByCode(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                         .build());
	    }
	    
	 @PostMapping("/agences")
	    public long save(@RequestBody Agence agences) {
		 
	        return  agencserv.save(agences);
	    }


	 @PutMapping("/agences/{code}")
	    public void update(@PathVariable String code, @RequestBody Agence Agence) {
	        Optional<Agence> cat = agencserv.findByCode(code);
	        if (cat.isPresent()) {
	            agencserv.update(code, Agence);
	        } else {
	            agencserv.save(Agence);
	        }
	    }

	  @DeleteMapping("/agences/{code}")
	    public void delete(@PathVariable String code) {
	        agencserv.delete(code);
	    }
	     
	  @GetMapping("/agences/5/{code}")
		 public ResponseEntity<List<Agence>> listCoddir(@PathVariable String code) {
				List<Agence>agences =  agencserv.findByCodedir(code);
		        return new ResponseEntity<List<Agence>>(agences, HttpStatus.OK);
		    }
}


