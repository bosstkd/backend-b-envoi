package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.Benvoi.Model.Client;

public interface ClientRepository  extends JpaRepository<Client ,Long>{
	Optional <Client> findByCode(String code);
	List<Client> findAllByLibelleContaining(String libelle);
	

}
