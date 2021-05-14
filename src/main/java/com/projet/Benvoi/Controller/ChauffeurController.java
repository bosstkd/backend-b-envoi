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

import com.projet.Benvoi.Model.Chauffeur;
import com.projet.Benvoi.Service.ChauffeurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ChauffeurController {
	@Autowired
	private ChauffeurService chaufService;
	
	@GetMapping("/chauffeurs")
    public List<Chauffeur> list() {
             return chaufService.getAll();
   }
	
	@GetMapping("/clients/{mat}")
	 public ResponseEntity<Chauffeur> post(@PathVariable String mat) {
	        Optional<Chauffeur>chauf= chaufService.findByMat(mat);
	        return chauf.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
	                                              .build());
	    }
	
	 @PostMapping("/chauffeurs")
	    public long save(@RequestBody Chauffeur chauffeur) {
	        return chaufService.save(chauffeur);
	    }
		   @PutMapping("/chauffeurs/{id}")
		   public void update(@PathVariable long id , @RequestBody Chauffeur chauffeur ) {
		   Optional<Chauffeur> post=chaufService.findById(id);
		   if(post.isPresent()) {
			   chaufService.update(id, chauffeur);
		   }
		   else {
			   chaufService.save(chauffeur);
		   }
		   }
		   @DeleteMapping("/chauffeurs/{id}")
		    public void delete (@PathVariable long id ) {
			   chaufService.delete(id);
		   }
		 
}
