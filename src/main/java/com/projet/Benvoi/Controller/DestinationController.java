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

import com.projet.Benvoi.Model.Destination;
import com.projet.Benvoi.Service.DestinationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DestinationController {
	@Autowired
	private DestinationService destService ;
	
	@GetMapping("/destinations/7")
	public int getCode() {
	System.out.println("Get Numbers ...");
	int x= destService.nbre();
	System.out.println(x);
	if(x==0) {
	return 0;	
	}
	else {
		return destService.max();
	}
	}
	
	
	
	@GetMapping("/destinations")
    public List<Destination> list() {
             return destService.getAll();
   }
 	 
 @GetMapping("/destinations/{id}")
 public ResponseEntity<Destination> post(@PathVariable String id) {
        Optional<Destination> dest = destService.findByCode(id);
        return dest.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/destinations")
    public long save(@RequestBody Destination Destination) {
        return destService.save(Destination);
    }
	   @PutMapping("/destinations/{id}")
	   public void update(@PathVariable String id , @RequestBody Destination Destination ) {
	   Optional<Destination> post=destService.findByCode(id);
	   if(post.isPresent()) {
		   destService.update(id, Destination);
	   }
	   else {
		   destService.save(Destination);
	   }
	   }
	   @DeleteMapping("/destinations/{id}")
	    public void delete (@PathVariable String id ) {
		   destService.delete(id);
	   }
	      
}