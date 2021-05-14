package com.projet.Benvoi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.Benvoi.Model.Ltarif;
import com.projet.Benvoi.Repository.LtarifRepository;

@Service
public class CalculDepoService {
	
	@Autowired
	private LtarifRepository tarifRepo;
	
	public Float montantTarif(Float poids) {
		
		List<Ltarif> lstTarif = tarifRepo.findAll();
		Float montant = 0F;
		for(Ltarif tarif:lstTarif) {
			if(poids>=tarif.getDeb()&&poids>=tarif.getFin()) {
				montant = (float) tarif.getMontant();
				break;
			}
		}
		
		
		return montant;
	}

}
