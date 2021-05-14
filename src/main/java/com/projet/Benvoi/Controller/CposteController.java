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


import com.projet.Benvoi.Model.Cposte;

import com.projet.Benvoi.Service.CposteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CposteController {
	@Autowired
    private CposteService cposteService;
 
 
 @GetMapping("/cpostes")
    public List<Cposte> list() {
	 System.out.println("Get all Cpostes...");
             return  cposteService.getAll();
   }
 	 
 @GetMapping("/cpostes/{id}")
 public ResponseEntity<Cposte> post(@PathVariable long id) {
        Optional<Cposte> cp =  cposteService.findById(id);
        return cp.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                           .build());
    }
    
 @PostMapping("/cpostes")
    public long save(@RequestBody Cposte cposte) {
	 
        return  cposteService.save(cposte);
    }

 @PutMapping("/cpostes/{id}")
    public void update(@PathVariable long id, @RequestBody Cposte cposte) {
        Optional<Cposte> cpo =  cposteService.findById(id);
        if (cpo.isPresent()) {
             cposteService.update(id, cposte);
        } else {
             cposteService.save(cposte);
        }
    }

  @DeleteMapping("/cpostes/{id}")
    public void delete(@PathVariable long id) {
         cposteService.delete(id);
    }
     
  
}

