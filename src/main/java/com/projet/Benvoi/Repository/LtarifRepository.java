package com.projet.Benvoi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.Benvoi.Model.Ltarif;


@Repository
public interface LtarifRepository extends JpaRepository<Ltarif, Long> {
	@Query(value = "SELECT count(code) FROM Ltarif")
	public int nbre();

	@Query(value = "SELECT max(code) FROM Ltarif")
	public int max();

	public Optional<Ltarif> findByCode(String code);

}
