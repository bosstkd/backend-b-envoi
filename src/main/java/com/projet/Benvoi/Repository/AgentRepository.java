package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.projet.Benvoi.Dto.ListAgence;
import com.projet.Benvoi.Dto.ListAgent;
//import com.projet.Benvoi.Model.Agence;
import com.projet.Benvoi.Model.Agent;
@Repository
public interface AgentRepository extends JpaRepository<Agent , Long>  {
	 @Query(value = "SELECT count(*)  FROM Agent   WHERE codeg  = :mat")

	   public int nbre(int mat);

		
		@Query(value = "SELECT max(code) FROM Agence  where codeg = :mat")
		
		public int max(int mat);
		
		
		
		
		
		@Query(value = "SELECT new com.projet.Benvoi.Dto.ListAgent (a.id , a.mat,a.nom,b.libelle,c.libelle,d.libelle, "
				+ " b.code,c.code,d.code)  from Agent a , Grade b , Agence c, Direction d where a.codeg=b.code "
				+ " and a.codres= c.code and c.codedir = d.code ")
     List<ListAgent> listAgent();


		public Optional<Agent> findByMat(int mat);


		public List<Agent> findAllByCodeg(String code);


		public List<Agent> findAllByCodres(String code);


	


		



}