package com.projet.Benvoi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.Benvoi.Model.Cposte;

@Repository
public interface CposteRepository extends JpaRepository<Cposte, Long>{
	

}
