package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.rapide.projet.Dto.ListCategorie;
import com.projet.Benvoi.Dto.ListAgence;
import com.projet.Benvoi.Model.Agence;
//import com.rapide.projet.Model.Scategorie;
@Repository
public interface AgenceRepository extends JpaRepository<Agence , Long> {
	Optional <Agence> findById(long id);
	Optional<Agence> findByCode(String code); 
	List<Agence> findAllByCodedir(String code);
	List<Agence> findAllByLibelleContaining(String libelle);
	
	@Query(value = "SELECT new com.projet.Benvoi.Dto.ListAgence (a.code,a.libelle,b.libelle,b.code)  from Agence a ,Direction b "
			+ "where a.codedir = b.code ")
	public   List<ListAgence> listAgence();
	List<Agence> findByCodedir(String code);

	
	@Query(value= "SELECT count(*)FROM Agence where codedir = :code")
	public int nbre(String code);
	@Query (value = "SELECT max (code)FROM Agence where codedir = :code")
	public int max(String code);
	Optional<Agence> findAllByCode(String code);
	
	

}
