package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.projet.Benvoi.Dto.ListTarif;
//import com.projet.Benvoi.Model.Agent;
import com.projet.Benvoi.Model.Tarif;
@Repository
public interface TarifRepository extends JpaRepository<Tarif, Long>{

	Optional<Tarif> findByCode(String code);


	List<Tarif> findAllByCode(String code);
	@Query(value = "SELECT count(code) FROM Tarif")
	public int nbre();

	
	@Query(value = "SELECT max(code) FROM Tarif")
	public int max();
	@Query(value = "SELECT new com.projet.Benvoi.Dto.ListTarif (a.code ,b.code,c.code, b.libelle ,c.libelle ,d.deb,d.fin,d.montant "
			+ ")  from Tarif a ,TypeCourrier b , Destination c, Ltarif d where a.typecourrier=b.code "
			+ " and a.codedes= c.code and a.code = d.code ")
	public   List<ListTarif> listTarif();


	


	List<Tarif> findAllByTypecourrier(String code);


	List<Tarif> findAllByCodedes(String code);


}
