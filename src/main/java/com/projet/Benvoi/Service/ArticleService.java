package com.projet.Benvoi.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.projet.Benvoi.Model.Article;
import com.projet.Benvoi.Repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {
	 @Autowired
		ArticleRepository repository;
	 
		public List<Article> getAll() {
			System.out.println("Get all Articles 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		
		
	    public Optional<Article> findByCode(String code) {
	        return repository.findByCode(code);
	    }
	    
	    public long save(Article article) {
	    	System.out.println("Save  Article");
	        Article art = new Article();
	        art.setCode(article.getCode());
	        art.setLibelle(article.getLibelle());
	        art.setCcateg(article.getCcateg());
	        
	        art.setPa(article.getPa());
	        art.setPv(article.getPv());
	        art.setFileName(article.getFileName());
	        art.setStock(article.getStock());
	        return repository.save(art)
	                             .getId();
	    }
	    public void update(String code, Article article) {
	        Optional<Article> artic = repository.findByCode(code);
	        if (artic.isPresent()) {
	            Article art = artic.get();
	            art.setCode(article.getCode());
		        art.setLibelle(article.getLibelle());
		        art.setCcateg(article.getCcateg());
		        
		        art.setPa(article.getPa());
		        art.setPv(article.getPv());
		     
		        art.setStock(article.getStock());
		        
		        repository.save(art);
	        }
	    }
	  
	
	    public List<Article> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(String code) {
	        Optional<Article> art = repository.findByCode(code);
	        art.ifPresent(repository::delete);
	    }
		
	    public List<Article> findByCcateg(String code) {
	        return repository.findAllByCcateg(code);
	    }

	    

		public int nbre(String code) {
			return repository.nbre(code);
		}



		public int max(String code) {
			return repository.max(code);
		}



		public Optional<Article> findById(Long id) {
			  return repository.findById(id);
		}





}