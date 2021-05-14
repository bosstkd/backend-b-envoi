package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet.Benvoi.Model.Client;
import com.projet.Benvoi.Repository.ClientRepository;
import com.projet.Benvoi.Repository.ParametreRepository;
import com.projet.Benvoi.Repository.UserRepository;

@Service
@Transactional
public class ClientService {
	@Autowired
	ClientRepository repository;
	@Autowired
	ParametreRepository paramRepository;
	@Autowired 
	UserRepository userRepository;
	public List<Client> getAll(){
		return repository.findAll(Sort.by("libelle").ascending());
		
	}

public Optional<Client> findByCode(String code){
return repository.findByCode(code);
}
/*public long save (Client Client) {

}*/
public Client createClient(Client client) {
Client clt =new Client();
     clt.setCode(client.getCode());
     clt.setLibelle(client.getLibelle());
     clt.setAdresse(client.getAdresse());
     clt.setTel(client.getTel());
     clt.setEmail(client.getEmail());
     clt.setLogin(client.getLogin());
     clt.setPwd(client.getPwd());
return repository.save(client);
}
public void update(String code ,Client client) {
 Optional<Client> clte= repository.findByCode(code);
 if (clte.isPresent()) {
	 Client clt=clte.get();
	 clt.setLibelle(client.getLibelle());
	 clt.setTel(client.getTel());
	 clt.setEmail(client.getEmail());
	 clt.setLogin(client.getLogin());
	 clt.setPwd(client.getPwd());
	 repository.save(clt);
 }
 
}
public List<Client> findByLibelle(String libelle){
return repository.findAllByLibelleContaining(libelle);
 
}

public void delete(String code) {
 Optional<Client> clte= repository.findByCode(code);
 clte.ifPresent(repository::delete);
}
}
