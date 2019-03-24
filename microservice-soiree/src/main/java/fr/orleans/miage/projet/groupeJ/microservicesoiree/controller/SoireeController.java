package fr.orleans.miage.projet.groupeJ.microservicesoiree.controller;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service.ISoiree;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
@RestController(value = "/")
public class SoireeController {

    @Autowired
    ISoiree facadeSoiree;

    //creer une soiree
    @PostMapping(value = "soiree")
    public long creerSoiree(@RequestBody Soiree soiree){
      long id =   facadeSoiree.creerSoiree(soiree);

        return id;

    }

    //participer a une soiree
    @PostMapping(value = "soiree/participe/{idSoiree}/{idParticipant}")
    public void participerSoiree(@PathVariable("idSoiree") long idSoiree,
                                 @PathVariable("participant") String participant){
        facadeSoiree.ajouterParticipantToSoiree(idSoiree, participant);

    }

    //ajouter un event private a une soiree
    @PutMapping(value = "soiree/{idSoiree}/eventPrivate/{idEventPrivate}")
    public ResponseEntity ajouterEventPriveeToSoiree(@PathVariable("idSoiree") long idSoiree,
                                           @PathVariable("idEventPrivate") long idEventPrivate){
        facadeSoiree.ajouterEventToSoiree(idSoiree,idEventPrivate);

        return ResponseEntity.ok().build();

    }

    //ajouter un event openData a une soiree
    @PutMapping(value = "soiree/{idSoiree}/eventopendata/{idEventOpenData}")
    public void ajouterEventOpenDataToSoiree(@PathVariable("idSoiree") long idSoiree,
                                             @PathVariable("idEventOpenData") long idEventOpenData){
        facadeSoiree.ajouterEventOpenDataToSoiree(idSoiree,idEventOpenData);

    }

    //recuperer  une soiree par id
    @GetMapping(value = "soiree/{idSoiree}")
    public Soiree getSoireeById(@PathVariable("idSoiree") long idSoiree){

        return facadeSoiree.getByIdSoiree(idSoiree);

    }

    //ajoute un participant à la soiree
    @PostMapping(value = "soiree/{idSoiree}/participe/{participant}")
    public void addParticipantToSoiree(@PathVariable("idSoiree") long idSoiree,
                                         @PathVariable("participant") String participant){

         facadeSoiree.ajouterParticipantToSoiree(idSoiree, participant);

    }


    //recuperer  toutes les soirees dun user
    @GetMapping(value = "soirees/{pseudo}")
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
