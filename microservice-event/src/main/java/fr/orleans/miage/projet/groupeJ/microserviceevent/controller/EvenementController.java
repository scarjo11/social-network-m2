package fr.orleans.miage.projet.groupeJ.microserviceevent.controller;

import fr.orleans.miage.projet.groupeJ.microserviceevent.dao.service.IEvenement;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.EvenementOpenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
@RestController(value = "/")
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
    @PostMapping(value = "event/openData", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public long openDataEventSave(@RequestBody EvenementOpenData evenementOpenData){
        long idEvementOpenData =  facade.creerEventOpenData(evenementOpenData);

        return idEvementOpenData;

    }

    //recuperer tous les evenet openData
    @GetMapping(value = "event")
    public Iterable<EvenementOpenData> getAllEventOpenData(){


        return facade.getAllEventOpenData();

    }

    //recuperer  tous les events
    @GetMapping(value = "event/{pseudo}")
    public Collection<Evenement> getEventByPseudo(@PathVariable("pseudo") String pseudo){
      return   facade.getEventPrviateByPseudo(pseudo);

    }

    //recuperer  tous les events
    @GetMapping(value = "event/private/{id}")
    public Evenement getEventById(@PathVariable("id") long id){
        return   facade.getEventPrviateById(id);

    }

    //recuperer  tous les opendata events
    @GetMapping(value = "event/openData/{id}")
    public EvenementOpenData getEventOpenDataById(@PathVariable("id") long id){
        return   facade.getEventOpenDataById(id);

    }
}
