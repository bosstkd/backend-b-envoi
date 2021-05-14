package com.projet.Benvoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.Benvoi.Model.Ldepot;

@Repository

public interface LdepotRepository extends JpaRepository<Ldepot, Long> {

	Optional<Ldepot> findByCode(String code);

	List<Ldepot> findAllByDesignationContaining(String libelle);

	// if poid >=deb and poids <= fin and destination = dest



}
