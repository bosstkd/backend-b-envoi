package com.projet.Benvoi.Controller;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
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

//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.projet.Benvoi.exception.ResourceNotFoundException;
import com.projet.Benvoi.Dto.ListTarif;
//import com.projet.Benvoi.Model.Categorie;
//import com.projet.Benvoi.Model.Destination;
//import com.projet.Benvoi.Model.Scategorie;
import com.projet.Benvoi.Model.Tarif;
//import com.projet.Benvoi.Service.CategorieService;
//import com.projet.Benvoi.Service.DestinationService;
import com.projet.Benvoi.Service.TarifService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TarifController {
	@Autowired TarifService tarifService;
	
	 
	 @GetMapping("/tarifs/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x =  tarifService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return  tarifService.max();
		 }
	 }
	 
	 @GetMapping("/tarifs")
	    public List<ListTarif> list() {
		 System.out.println("Get all tarifs...");
	             return tarifService.getAll();
	   }
	 

	 @GetMapping("/tarifs/{code}")
	    public List<Tarif> listTarif(@PathVariable String code) {
		 System.out.println("Get all tarifs...");
	             return tarifService.findAllByCode(code);
	   }
	 	 
	 @GetMapping("/tarifs/{id}")
	 public ResponseEntity<Tarif> post(@PathVariable String id) {
	        Optional<Tarif> cat = tarifService.findById(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                            .build());
	    }
	    
	 @PostMapping("/tarifs")
	    public void save(@RequestBody Tarif tarif) {
		 System.out.println(tarif);
	         tarifService.save(tarif);
	    }
	 @PutMapping("/tarifs/{id}")
	    public void update(@PathVariable String id, @RequestBody Tarif tarif) {
	        Optional<Tarif> cat =   tarifService.findById(id);
	        if (cat.isPresent()) {
	        	  tarifService.update(id,tarif);
	        } 
	    }

	  @DeleteMapping("/tarifs/{id}")
	    public void delete(@PathVariable String id) {
		  tarifService.delete(id);
	    }
	     
	  
}