package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.Benvoi.Model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long>{
	Optional <Destination> findByCode(String code);
	List<Destination> findAllByLibelleContaining(String libelle);
	@Query(value= "SELECT count(code)FROM Destination")
	public int nbre();
	@Query (value = "SELECT max (code)FROM Destination")
	public int max();
	
	

}