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
import com.projet.Benvoi.Model.Grade;
import com.projet.Benvoi.Service.GradeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GradeController {
	@Autowired
    private GradeService gradeService;

 
 @GetMapping("/grades")
    public List<Grade> list() {
	 System.out.println("Get all Grades...");
             return gradeService.getAll();
   }
 @GetMapping("/grades/{id}")
 public ResponseEntity<Grade> post(@PathVariable long id) {
        Optional<Grade> gra = gradeService.findById(id);
        return gra.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                           .build());
    }
 @PutMapping("/grades/{id}")
 public void update(@PathVariable long id , @RequestBody Grade grade) {
     Optional<Grade> gra = gradeService.findById(id);
     if (gra.isPresent()) {
         gradeService.update(id, grade);
     }
 }  
 @DeleteMapping("/grades/{id}")
 public void delete(@PathVariable long id) {
     gradeService.delete(id);
 }
@PostMapping("/grades")
 public long save(@RequestBody Grade grade) {
	 
     return gradeService.save(grade);
 }
  

}
