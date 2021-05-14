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

//import com.projet.Benvoi.Model.Depot;
import com.projet.Benvoi.Model.Ldepot;
//import com.projet.Benvoi.Service.DepotService;
import com.projet.Benvoi.Service.LdepotService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LdepotController {

	@Autowired
    private LdepotService ldepotserv;
 @GetMapping("/ldepots")
    public List<Ldepot> list() {
	 System.out.println("Get all ldepots...");
             return  ldepotserv.getAll();
   }
 	 
 @GetMapping("/ldepots/{id}")
 public ResponseEntity<Ldepot> post(@PathVariable long id) {
        Optional<Ldepot> dep=  ldepotserv.findById(id);
        return dep.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                        .build());
    }
    
 @PostMapping("/ldepots")
    public long save(@RequestBody Ldepot ldepot) {
	 
        return  ldepotserv.save(ldepot);
    }

 @PutMapping("/ldepots/{id}")
    public void update(@PathVariable long id, @RequestBody Ldepot ldepot) {
        Optional<Ldepot> cat = ldepotserv.findById(id);
        if (cat.isPresent()) {
        	 ldepotserv.update(id, ldepot);
        } else {
        	 ldepotserv.save(ldepot);
        }
    }

  @DeleteMapping("/ldepots/{id}")
    public void delete(@PathVariable long id) {
	  ldepotserv.delete(id);
    }
     
  
}



