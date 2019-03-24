package fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.EvenementOpenData;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;

import java.util.Collection;

/**
 * Created by wilfrid on 16/03/2019.
 */
public interface IEvenement {

    /**
     * Permet de creer un nouvel evenement  pour le pseudo
     * @param event : objet evenement
     */
    long creerEventPrivee(Evenement event);

    /**
     * Permet de creer un nouvel evenement  via openData
     * @param evenementOpenData : objet evenement
     */
    long creerEventOpenData(EvenementOpenData evenementOpenData);


    /**
     * Permet de recuperer tous  evenement  de openData
     */
    Iterable<EvenementOpenData> getAllEventOpenData();

    /**
     * Permet de recuperer tous  evenement privee  d'un utilisateur
     */
    Collection<Evenement> getEventPrviateByPseudo(String pseudo);
}
