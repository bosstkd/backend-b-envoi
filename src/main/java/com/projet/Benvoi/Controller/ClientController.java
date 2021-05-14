package com.projet.Benvoi.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.projet.Benvoi.Model.Client;
import com.projet.Benvoi.Model.Parametre;
import com.projet.Benvoi.Model.User;
import com.projet.Benvoi.Repository.UserRepository;
import com.projet.Benvoi.Service.ClientService;
import com.projet.Benvoi.Service.ParametreService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private ClientService cltService;
	@Autowired
	private ParametreService parService ;
	@Autowired
	private UserRepository userRepository;
	
	/*@GetMapping("/clients/7")
	public int getCode() {
	System.out.println("Get Numbers ...");
	int x= cltService.nbre();
	System.out.println(x);
	if(x==0) {
	return 0;	
	}
	else {
		return cltService.max();
	}
	}*/
	@GetMapping("/clients")
    public List<Client> list() {
             return cltService.getAll();
   }
	
	@GetMapping("/clients/{id}")
	 public ResponseEntity<Client> post(@PathVariable String id) {
	        Optional<Client> clt = cltService.findByCode(id);
	        return clt.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
	                                              .build());
	    }
	
	    
	@PostMapping("/clients")
	    public  Client createClient(@Valid @RequestBody Client client) {
		 long id= 1;
		 Optional<Parametre> ParametreInfo =parService.findById(id);
		 if (ParametreInfo.isPresent()) {
		    	Parametre par = ParametreInfo.get();
		           par.setNumc(par.getNumc()+1);

			          par = parService.createParametre(par);
			    }
		 User user=new User();
		 user.setUsername(client.getLogin());
		 user.setEmail(client.getEmail());
		 user.setPassword(client.getPwd());
		 user.setRole("Client");
		 user.setActive(true);
		 userRepository.save(user);
	        return cltService.createClient(client);
	}
		   @PutMapping("/clients/{id}")
		   public void update(@PathVariable String id , @RequestBody Client client ) {
		   Optional<Client> post=cltService.findByCode(id);
		   if(post.isPresent()) {
			   cltService.update(id, client);
		   }
		   else {
			   cltService.createClient(client);
		   }
		   }
		   @DeleteMapping("/clients/{id}")
		    public void delete (@PathVariable String id ) {
			   cltService.delete(id);
		   }
		      

}
