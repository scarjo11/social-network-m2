package fr.orleans.miage.projet.groupeJ.microserviceclient.controller;

import fr.orleans.miage.projet.groupeJ.microserviceclient.beans.EvenementBean;
import fr.orleans.miage.projet.groupeJ.microserviceclient.proxies.MicroserviceSoireeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 17/03/2019.
 */
@Controller
@SessionAttributes("pseudo")
public class SoireeController {

    @Autowired
    MicroserviceSoireeProxy microserviceSoireeProxy;


    @GetMapping(value = "event")
    public String addEvenementPriveeTemplate(Model model,
                     @SessionAttribute(value="pseudo", required = false) String pseudo){

        model.addAttribute("event", new EvenementBean());
        model.addAttribute("pseudo", pseudo);

        return "addEventPrivate";
    }


    @PostMapping(value = "event")
    public String addEvenementPrivee(@ModelAttribute EvenementBean evenement, Model model,
                                     @SessionAttribute(value="pseudo", required = false) String pseudo){

        microserviceSoireeProxy.creerEvenementPrivee(evenement);

        model.addAttribute("event", new EvenementBean());
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("msg", "votre evenement a ete bien ajouté");

        return "addEventPrivate";
    }


    @GetMapping(value = "event/{pseudo}")
    String getEventByPseudo(@PathVariable("pseudo") String pseudo){

        Collection<EvenementBean> event =  microserviceSoireeProxy.getEventBy(pseudo);

        return "allPrivateEvent";
    }


}
