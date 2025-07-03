package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id) {
        Optional<Produit> produitOptional= produitRepository.findById(id);

        if(produitOptional.isEmpty()){
            throw  new RuntimeException("Desolé produit");
        }
        return produitOptional.get();
    }

    public String deleteProduitById(long idProduit) {
        Optional<Produit> deleteOptional= produitRepository.findById(idProduit);

        if(deleteOptional.isEmpty()){
            throw  new RuntimeException("suppression impossible");
        }
        produitRepository.delete(deleteOptional.get());
        return "Produit supprimer avec succés";
    }

    public Produit editProduit(long id,Produit produit) {
       Optional<Produit> produitOptional=produitRepository.findById(id);

       if(produitOptional.isEmpty()){
           throw new RuntimeException("modification impossible");

       }
       Produit produitAModifier = produitOptional.get();
       produitAModifier.setName(produit.getName());
       produitAModifier.setPrice(produit.getPrice());

       return produitRepository.save(produitAModifier);
    }
}

