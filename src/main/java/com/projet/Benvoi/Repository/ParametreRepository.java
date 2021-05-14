package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.Benvoi.Model.Parametre;

public interface ParametreRepository  extends JpaRepository<Parametre, Long>{
	Optional <Parametre> findByCode(String code);
	List<Parametre> findAllByLibelleContaining(String libelle);
	
	 

}
