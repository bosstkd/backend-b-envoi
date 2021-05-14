package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.Benvoi.Model.Chauffeur;
public interface ChauffeurRepository extends JpaRepository <Chauffeur, Long> {
	List<Chauffeur> findAllByLibelleContaining(String libelle);
	Optional<Chauffeur> findById(Long id);

	Optional<Chauffeur> findByMat(String mat);
}
