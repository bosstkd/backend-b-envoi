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

import com.projet.Benvoi.Model.Direction;
import com.projet.Benvoi.Service.DirectionService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DirectionController {
	@Autowired
	private DirectionService direcService ;
	
	/*@GetMapping("/agences/7")
	public int getCode() {
	System.out.println("Get Numbers ...");
	int x= agctService.nbre();
	System.out.println(x);
	if(x==0) {
	return 0;	
	}
	else {
		return catService.max();
	}
	}
	*/
	
	
	@GetMapping("/directions")
    public List<Direction> list() {
             return direcService.getAll();
   }
 	 
 @GetMapping("/directions/{id}")
 public ResponseEntity<Direction> post(@PathVariable long id) {
        Optional<Direction> cat = direcService.findById(id);
        return cat.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/directions")
    public long save(@RequestBody Direction direction) {
        return direcService.save(direction);
    }
	   @PutMapping("/directions/{id}")
	   public void update(@PathVariable long id , @RequestBody Direction direction) {
	   Optional<Direction> post=direcService.findById(id);
	   if(post.isPresent()) {
		  direcService.update(id,  direction);
	   }
	  
	   }
	   @DeleteMapping("/directions/{id}")
	    public void delete (@PathVariable long id ) {
		   direcService.delete(id);
	   }
	      


}
