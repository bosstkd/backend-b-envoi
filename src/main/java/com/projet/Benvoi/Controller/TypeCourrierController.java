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
import com.projet.Benvoi.Model.TypeCourrier;
import com.projet.Benvoi.Service.TypeCourrierService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TypeCourrierController {
	@Autowired
	private TypeCourrierService courService ;
	
	@GetMapping("/typecourriers/7")
	public int getCode() {
	System.out.println("Get Numbers ...");
	int x= courService.nbre();
	System.out.println(x);
	if(x==0) {
	return 0;	
	}
	else {
		return courService.max();
	}
	}
	
	
	
	@GetMapping("/typecourriers")
    public List<TypeCourrier> list() {
             return courService.getAll();
   }
 	 
 @GetMapping("/typecourriers/{id}")
 public ResponseEntity<TypeCourrier> post(@PathVariable String id) {
        Optional<TypeCourrier> cour = courService.findByCode(id);
        return cour.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/typecourriers")
    public long save(@RequestBody TypeCourrier TypeCourrier) {
        return courService.save(TypeCourrier);
    }
	   @PutMapping("/typecourriers/{id}")
	   public void update(@PathVariable String id , @RequestBody TypeCourrier TypeCourrier ) {
	   Optional<TypeCourrier> post=courService.findByCode(id);
	   if(post.isPresent()) {
		   courService.update(id, TypeCourrier);
	   }
	   else {
		   courService.save(TypeCourrier);
	   }
	   }
	   @DeleteMapping("/typecourriers/{id}")
	    public void delete (@PathVariable String id ) {
		   courService.delete(id);
	   }
	      
}