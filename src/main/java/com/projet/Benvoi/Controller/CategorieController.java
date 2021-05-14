package com.projet.Benvoi.Controller;

import java.util.List;
import java.util.Optional;

//import javax.servlet.http.HttpServletResponse;

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
import com.projet.Benvoi.Model.Categorie;
import com.projet.Benvoi.Service.CategorieService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {
	@Autowired
	private CategorieService catService ;
	
	@GetMapping("/categories/7")
	public int getCode() {
	System.out.println("Get Numbers ...");
	int x= catService.nbre();
	System.out.println(x);
	if(x==0) {
	return 0;	
	}
	else {
		return catService.max();
	}
	}
	
	
	
	@GetMapping("/categories")
    public List<Categorie> list() {
             return catService.getAll();
   }
 	 
 @GetMapping("/categories/{id}")
 public ResponseEntity<Categorie> post(@PathVariable String id) {
        Optional<Categorie> cat = catService.findByCode(id);
        return cat.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/categories")
    public long save(@RequestBody Categorie categorie) {
        return catService.save(categorie);
    }
	   @PutMapping("/categories/{id}")
	   public void update(@PathVariable String id , @RequestBody Categorie categorie ) {
	   Optional<Categorie> post=catService.findByCode(id);
	   if(post.isPresent()) {
		   catService.update(id, categorie);
	   }
	   else {
		   catService.save(categorie);
	   }
	   }
	   @DeleteMapping("/categories/{id}")
	    public void delete (@PathVariable String id ) {
		   catService.delete(id);
	   }
	      
}