package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.Benvoi.Model.TypeCourrier;

public interface TypeCourrierRepository extends JpaRepository<TypeCourrier, Long>{
	Optional <TypeCourrier> findByCode(String code);
	List<TypeCourrier> findAllByLibelleContaining(String libelle);
	@Query(value= "SELECT count(code)FROM TypeCourrier")
	public int nbre();
	@Query (value = "SELECT max (code)FROM TypeCourrier")
	public int max();

}
