package com.projet.Benvoi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.Benvoi.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User>findByUsername(String name);
	 

	//User findbyEmail(String email);
}
