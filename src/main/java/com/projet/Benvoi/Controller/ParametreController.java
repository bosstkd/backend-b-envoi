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
import com.projet.Benvoi.Model.Parametre;
import com.projet.Benvoi.Service.ParametreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ParametreController {
	@Autowired
	private ParametreService parService ;
	
	
	
	
	
	@GetMapping("/parametres")
    public List<Parametre> list() {
             return parService.getAll();
   }
	
 @GetMapping("/parametres/{id}")
 public ResponseEntity<Parametre> post(@PathVariable int id) {
        Optional<Parametre> par = parService.findById(id);
        return par.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/parametres")
    public Parametre createParametre(Parametre parametre)  {
        return parService.createParametre(parametre);
    }
	   @PutMapping("/parametres/{id}")
	   public void update(@PathVariable String id , @RequestBody Parametre parametre ) {
	   Optional<Parametre> post=parService.findByCode(id);
	   if(post.isPresent()) {
		   parService.update(id, parametre);
	   }
	   else {
		   parService.createParametre(parametre);
	   }
	   }
	   @DeleteMapping("/parametres/{id}")
	    public void delete (@PathVariable String id ) {
		   parService.delete(id);
	   }
	      
}
