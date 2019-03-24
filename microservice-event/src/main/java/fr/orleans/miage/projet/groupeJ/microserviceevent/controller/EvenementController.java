package fr.orleans.miage.projet.groupeJ.microservicesoiree.controller;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository.SoireeRepository;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service.IEvenement;
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
@RestController(value = "/event")
public class EvenementController {

    @Autowired
    private IEvenement facade;

    //creer un event
    @PostMapping(value = "event")
    public ResponseEntity<Long> creerEvenementPrivee(@RequestBody Evenement evenement){
      long idEvement =  facade.creerEventPrivee(evenement);

        return ResponseEntity.ok(idEvement);

    }

    //sauvegarder les evenement opendata dans notre base
    @PostMapping(value = "event/openData")
    public ResponseEntity<Long> openDataEventSave(@RequestBody EvenementOpenData evenementOpenData){
        long idEvementOpenData =  facade.creerEventOpenData(evenementOpenData);

        return ResponseEntity.ok(idEvementOpenData);

    }

    //recuperer tous les evenet openData
    @GetMapping(value = "event")
    public Iterable<EvenementOpenData> getAllEventOpenData(){


        return facade.getAllEventOpenData();

    }

    //recuperer  toutes les soirees
    @GetMapping(value = "event/{pseudo}")
    public Collection<Evenement> getEventBy(@PathVariable("pseudo") String pseudo){
      return   facade.getEventPrviateByPseudo(pseudo);

    }

}
