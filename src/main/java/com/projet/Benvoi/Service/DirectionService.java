package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projet.Benvoi.Model.Direction;
import com.projet.Benvoi.Repository.DirectionRepository;

@Service
@Transactional
public class DirectionService {
	@Autowired
	DirectionRepository repository;
	public List<Direction> getAll(){
		return repository.findAll(Sort.by("libelle").ascending());
		
	}
	/*public int max() {
	return repository.max();	
	}
	public int nbre() {
		return repository.nbre();
	}*/
	
public Optional<Direction> findById(long id){
	return repository.findById(id);
	}
public long save(Direction direction) {
	Direction direc =new Direction();
	direc.setCode(direction.getCode());
	direc.setLibelle(direction.getLibelle());
	return repository.save(direc).getId();
}
 public void update(long id ,Direction direction) {
	 Optional<Direction> direct= repository.findById(id);
	 if (direct.isPresent()) {
		 Direction direc =direct.get();
		direc.setLibelle(direction.getLibelle());
		 repository.save(direc);
	 }
	 
 }
 public List<Direction> findByLibelle(String libelle){
	return repository.findAllByLibelleContaining(libelle);
	 
 }
 
 public void delete(long id) {
	 Optional<Direction> direct= repository.findById(id);
	 direct.ifPresent(repository::delete);
 }

}
