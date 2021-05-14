package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.projet.Benvoi.Model.Chauffeur;
import com.projet.Benvoi.Repository.ChauffeurRepository;

@Service
@Transactional
public class ChauffeurService {
	@Autowired
	ChauffeurRepository repository;
	public List<Chauffeur> getAll(){
		return repository.findAll(Sort.by("libelle").ascending());
		
	}	
	

	public Optional<Chauffeur> findById(long id){
		return repository.findById(id);
		}
		public long save(Chauffeur chauffeur) {
		Chauffeur chauf =new Chauffeur();
		chauf.setMat(chauffeur.getMat());
		chauf.setNom(chauffeur.getNom());
		chauf.setLibelle(chauffeur.getLibelle());
		chauf.setGrade(chauffeur.getGrade());
		chauf.setDestination(chauffeur.getDestination());
		chauf.setTel(chauffeur.getTel());
		chauf.setAgence(chauffeur.getAgence());
		chauf.setDirection(chauffeur.getDirection());
		chauf.setEmail(chauffeur.getEmail());
		chauf.setLogin(chauffeur.getLogin());
		chauf.setPwd(chauffeur.getPwd());
		return repository.save(chauf).getId();
		}
		public void update(long id ,Chauffeur chauffeur) {
		 Optional<Chauffeur> clte= repository.findById(id);
		 if (clte.isPresent()) {
			 Chauffeur chauf=clte.get();
			 chauf.setNom(chauffeur.getNom());
			 chauf.setGrade(chauffeur.getGrade());
			 chauf.setDestination(chauffeur.getDestination());
			 chauf.setTel(chauffeur.getTel());
			 chauf.setAgence(chauffeur.getAgence());
			 chauf.setDirection(chauffeur.getDirection());
			 repository.save(chauf);
		 }
		 
		}
		public List<Chauffeur> findByLibelle(String libelle){
		return repository.findAllByLibelleContaining(libelle);
		 
		}

		public void delete(long id) {
		 Optional<Chauffeur> clte= repository.findById(id);
		 clte.ifPresent(repository::delete);
		}


		public Optional<Chauffeur> findByMat(String mat) {
			return repository.findByMat(mat);
		}
		}

