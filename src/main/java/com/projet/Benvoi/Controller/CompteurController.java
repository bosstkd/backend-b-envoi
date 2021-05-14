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

import com.projet.Benvoi.Model.Compteur;
import com.projet.Benvoi.Service.CompteurService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CompteurController {
	@Autowired
	private CompteurService cptService ;
	
	
	
	
	@GetMapping("/compteurs")
    public List<Compteur> list() {
		System.out.println("Get all Compteurs ...");
             return cptService.getAll();
   }
 	 
 @GetMapping("/compteurs/{annee}")
 public ResponseEntity<Compteur> post(@PathVariable int annee) {
        Optional<Compteur> cpt = cptService.findByAnnee(annee);
        return cpt.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/compteurs")
    public long save(@RequestBody Compteur compteur) {
        return cptService.save(compteur);
    }
	   @PutMapping("/compteurs/{id}")
	   public void update(@PathVariable long id , @RequestBody Compteur compteur ) {
	   Optional<Compteur> post=cptService.findById(id);
	   if(post.isPresent()) {
		   cptService.update(id, compteur);
	   }
	 
	   }
	   @DeleteMapping("/compteurs/{id}")
	    public void delete (@PathVariable long id ) {
		   cptService.delete(id);
	   }
	      

}
