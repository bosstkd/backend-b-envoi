package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projet.Benvoi.Model.User;
import com.projet.Benvoi.Repository.UserRepository;

@Service
@Transactional
public class UserService {
   @Autowired
   UserRepository repository;
   
   public List<User>getAll(){
	System.out.println("Get all Users");
	return repository.findAll(Sort.by("username").ascending());
   }
   
   public Optional<User>findById(long id){
	   return repository.findById(id);
   }
   
   public long save(User User ) {
	   	System.out.println("Save All Users");
	   	User user =new User();
	   	user.setUsername(User.getUsername());
	   	user.setEmail(User.getEmail());
	   	user.setPassword(User.getPassword());
	   	user.setRole(User.getRole());
	   	user.setActive(User.isActive());
	   	return repository.save(user)
	   			             .getId();
   }
   
   public void update(long id,User User) {
	   Optional<User> userr = repository.findById(id);
	   if(userr.isPresent()) {
			User user =new User();
		   	user.setUsername(User.getUsername());
		   	user.setEmail(User.getEmail());
		   	user.setPassword(User.getPassword());
		   	user.setRole(User.getRole());
		   	user.setActive(User.isActive());
		   	repository.save(user);
	   }
   }
   
   public Optional <User>login(String name){
	   return repository.findByUsername(name);
   }
   
   public void delete(long id) {
	   Optional <User> user = repository.findById(id);
	   user.ifPresent(repository::delete);
   }
 /*  public User fetchUserByEmail(String email) {
	   return repository.findbyEmail(email);
   }*/
   
   
}
