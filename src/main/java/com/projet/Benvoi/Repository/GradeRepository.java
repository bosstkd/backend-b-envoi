package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import com.projet.Benvoi.Model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{

	Optional<Grade> findByCode(String code);
	List<Grade> findAllByLibelleContaining(String libelle);

	List<Grade> findAllByCode(String code);

}

