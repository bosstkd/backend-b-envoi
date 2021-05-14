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

import com.projet.Benvoi.Model.User;
import com.projet.Benvoi.Service.UserService;



@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class UserController {
@Autowired
private UserService userService;

@GetMapping("/users")

   public List<User> list() {
System.out.println("Get all users...");
            return userService.getAll();
  }

@GetMapping("/users/{id}")
public ResponseEntity<User> post(@PathVariable long id) {
       Optional<User> user = userService.findById(id);
       return user.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound()
                                                 .build());
   }
@GetMapping("/users/auth/{username}")
public ResponseEntity<User> login(@PathVariable String username) {
       Optional<User> user = userService.login(username);
       return user.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound()
                                                 .build());
   }


@PostMapping("/users")
   public long save(@RequestBody User user) {

System.out.println("save all USERS...");
       return userService.save(user);
   }

@PutMapping("/users/{id}")
   public void update(@PathVariable long id, @RequestBody User user) {
       Optional<User> cat = userService.findById(id);
       if (cat.isPresent()) {
           userService.update(id, user);
       } else {
           userService.save(user);
       }
   }

   @DeleteMapping("/users/{id}")
   public void delete(@PathVariable long id) {
       userService.delete(id);
   }
   
 
   



}





