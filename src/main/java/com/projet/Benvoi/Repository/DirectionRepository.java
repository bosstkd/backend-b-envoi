package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.Benvoi.Model.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
	Optional <Direction> findById(long id);
	List<Direction> findAllByLibelleContaining(String libelle);

}
