package fr.orleans.miage.projet.groupeJ.microservicesoiree.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by wilfrid on 06/03/2019.
 */
@Entity
public class Soiree {

    @Id
    @GeneratedValue
    private  long id;
    private String nom;

    //lid du user qui creer la soiree
    private String pseudo;

    //liste des participant (pseudo) de la soiree
    @ElementCollection
    private Collection<String> participant;

    //evenement recuperer de l'api open data
    @OneToMany(
            mappedBy = "soiree_ext",
            cascade = CascadeType.ALL
            // orphanRemoval = true
    )
    private Collection<EvenementOpenData> evenementsExterne;


    @OneToMany(
            mappedBy = "soiree_int",
            cascade = CascadeType.ALL
           // orphanRemoval = true
    )
    //evenement creer par l'utilisateur lui meme qui s'ajoute à la soiree
    private Collection<Evenement> evenementsPrivee;

    public Soiree() {
    }

    public Soiree(String nom, String pseudo) {
        this.nom = nom;
        this.pseudo = pseudo;
        this.evenementsExterne = new ArrayList<>();
        this.evenementsPrivee = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Collection<String> getParticipant() {
        return participant;
    }

    public void setParticipant(Collection<String> participant) {
        this.participant = participant;
    }

    public Collection<EvenementOpenData> getEvenementsExterne() {
        return evenementsExterne;
    }

    public void setEvenementsExterne(Collection<EvenementOpenData> evenementsExterne) {
        this.evenementsExterne = evenementsExterne;
    }

    public Collection<Evenement> getEvenementsPrivee() {
        return evenementsPrivee;
    }

    public void setEvenementsPrivee(Collection<Evenement> evenementsPrivee) {
        this.evenementsPrivee = evenementsPrivee;
    }
}
