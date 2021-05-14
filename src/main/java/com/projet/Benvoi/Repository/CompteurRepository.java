package com.projet.Benvoi.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projet.Benvoi.Model.Compteur;

public interface CompteurRepository  extends JpaRepository<Compteur, Long>{

	Optional<Compteur> findByAnnee(int annee);

	
	
}
