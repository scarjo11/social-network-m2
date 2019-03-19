package fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.EvenementOpenData;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;

import java.util.Collection;

/**
 * Created by wilfrid on 16/03/2019.
 */
public interface ISoiree {

    /**
     * Permet de de creer une nouvelle soiree
     * @param soiree : objet soiree a creer
     * @return l'id de la soiree
     */
    long creerSoiree(Soiree soiree);


    /**
     * Permet de recuperer une soiree
     * @param id : id de la soiree
     * @return  la soiree
     */
    Soiree getByIdSoiree(long id);

    /**
     * Permet de de creer une nouvelle soiree
     * @param pseudo : pseudo de celui qui aa creer de la soiree
     * @return  collection de  soiree
     */
    Collection<Soiree> getSoireesByPseudo(String  pseudo);

    /**
     * Permet d'ajouter un evenement privee a une soiree
     * @param idSoiree : id soiree
     * @param evenement : event privee a ajouter à la soiree
     */
    void ajouterEventToSoiree(long idSoiree,  Evenement evenement);

    /**
     * Permet d'ajouter un event open data à une soiree
     * @param idSoiree : id soiree
     * @param evenementOpenData : event opendata a ajouter à la soiree
     */
    void ajouterEventOpenDataToSoiree(long idSoiree, EvenementOpenData evenementOpenData);

    /**
     * Permet dajouter  un participant à la soiree
     * @param idSoiree : lid de la soiree
     * @param participant : le pseudo decelui qui aimerait participer à la soiree
     */
    void ajouterParticipantToSoiree(long idSoiree, String participant);



}
