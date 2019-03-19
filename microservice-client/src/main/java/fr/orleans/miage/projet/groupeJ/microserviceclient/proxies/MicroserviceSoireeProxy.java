package fr.orleans.miage.projet.groupeJ.microserviceclient.proxies;

import fr.orleans.miage.projet.groupeJ.microserviceclient.beans.*;
import fr.orleans.miage.projet.groupeJ.microserviceclient.domain.Follow;
import fr.orleans.miage.projet.groupeJ.microserviceclient.domain.Login;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 12/03/2019.
 */
@FeignClient(name = "gateway")
//@FeignClient(name = "zuul-server")
//@FeignClient(name = "microservice-soiree", url = "localhost:8084")
public interface MicroserviceSoireeProxy {


    //eventcontroller
    @PostMapping(value = "/microservice-soiree/event")
    ResponseEntity<Long> creerEvenementPrivee(@RequestBody EvenementBean evenement);

    @PostMapping(value = "/microservice-soiree/event/openData")
    ResponseEntity<Long> openDataEventSave(@RequestBody EvenementOpenDataBean evenementOpenData);

    @GetMapping(value = "/microservice-soiree/event")
    Iterable<EvenementOpenDataBean> getAllEventOpenData();

    @GetMapping(value = "/microservice-soiree/event/{pseudo}")
    Collection<EvenementBean> getEventBy(@PathVariable("pseudo") String pseudo);

    //soireecontroller

    @PostMapping(value = "/microservice-soiree/soiree")
     ResponseEntity<Long> creerSoiree(@RequestBody SoireeBean soiree);


    @PostMapping(value = "/microservice-soiree/soiree/participe/{idSoiree}/{idParticipant}")
     void participerSoiree(@PathVariable("idSoiree") long idSoiree,
                                 @PathVariable("participant") String participant);


    @PostMapping(value = "/microservice-soiree/soiree/{idSoiree}/eventPrivate")
     void ajouterEventPriveeToSoiree(@PathVariable("idSoiree") long idSoiree,
                                           @RequestBody EvenementBean evenement);



    @PostMapping(value = "/microservice-soiree/soiree/{idSoiree}/eventopendata")
     void ajouterEventOpenDataToSoiree(@PathVariable("idSoiree") long idSoiree,
                                             @RequestBody EvenementOpenDataBean evenementOpenData);



    @GetMapping(value = "/microservice-soiree/soiree/{idSoiree}")
     SoireeBean getSoireeById(@PathVariable("idSoiree") long idSoiree);



    @GetMapping(value = "/microservice-soiree/soiree/{pseudo}")
     Collection<SoireeBean> getAllSoiree(@PathVariable("pseudo") String pseudo);
}
