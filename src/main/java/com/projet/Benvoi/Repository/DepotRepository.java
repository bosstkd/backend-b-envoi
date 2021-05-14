package com.projet.Benvoi.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.Benvoi.Dto.ListDepot;
import com.projet.Benvoi.Dto.ListTarif;
import com.projet.Benvoi.Model.Depot;
//import com.projet.Benvoi.Model.Tarif;

@Repository

public interface DepotRepository extends JpaRepository<Depot, Long> {
	
	Optional<Depot> findByCode(String code);

	List<Depot> findAllByCode(String code);
//	@Query(value = "SELECT new com.projet.Benvoi.Dto.ListDepot ()
			
//	List<ListDepot> listdepot();
	
	


}
