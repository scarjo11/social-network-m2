package fr.orleans.miage.projet.groupeJ.microservicesoiree.controller;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository.SoireeRepository;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service.ISoiree;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.EvenementOpenData;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
@RestController(value = "/soiree")
public class SoireeController {

    @Autowired
    ISoiree facadeSoiree;

    //creer une soiree
    @PostMapping(value = "soiree")
    public ResponseEntity<Long> creerSoiree(@RequestBody Soiree soiree){
      long id =   facadeSoiree.creerSoiree(soiree);

        return ResponseEntity.ok(id);

    }

    //participer a une soiree
    @PostMapping(value = "soiree/participe/{idSoiree}/{idParticipant}")
    public void participerSoiree(@PathVariable("idSoiree") long idSoiree,
                                 @PathVariable("participant") String participant){
        facadeSoiree.ajouterParticipantToSoiree(idSoiree, participant);

    }

    //ajouter un event private a une soiree
    @PostMapping(value = "soiree/{idSoiree}/eventPrivate")
    public void ajouterEventPriveeToSoiree(@PathVariable("idSoiree") long idSoiree,
                                           @RequestBody Evenement evenement){
        facadeSoiree.ajouterEventToSoiree(idSoiree,evenement);

    }

    //ajouter un event openData a une soiree
    @PostMapping(value = "soiree/{idSoiree}/eventopendata")
    public void ajouterEventOpenDataToSoiree(@PathVariable("idSoiree") long idSoiree,
                                           @RequestBody EvenementOpenData evenementOpenData){
        facadeSoiree.ajouterEventOpenDataToSoiree(idSoiree,evenementOpenData);

    }

    //recuperer  une soiree par id
    @GetMapping(value = "soiree/{idSoiree}")
    public Soiree getSoireeById(@PathVariable("idSoiree") long idSoiree){

        return facadeSoiree.getByIdSoiree(idSoiree);

    }


    //recuperer  toutes les soirees dun user
    @GetMapping(value = "soiree/{pseudo}")
    public Collection<Soiree> getAllSoiree(@PathVariable("pseudo") String pseudo){

        return facadeSoiree.getSoireesByPseudo(pseudo);

    }

/*
    //supprimer une soiree
    @DeleteMapping(value = "soiree")
    public ResponseEntity<Void> deleteSoiree(@RequestParam("idSoiree") int idSoiree,
                                             @RequestParam("idUser") int idUser){

        return null;

    }


    //update une soiree
    @PutMapping(value = "soiree")
    public ResponseEntity<Void> updateSoiree(@RequestParam("idSoiree") int idSoiree,
                                             @RequestParam("idUser") int idUser){

        return null;

    }
*/
}
