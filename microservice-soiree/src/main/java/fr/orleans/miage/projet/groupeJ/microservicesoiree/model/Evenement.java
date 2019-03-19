package fr.orleans.miage.projet.groupeJ.microservicesoiree.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wilfrid on 06/03/2019.
 */
@Entity
public class Evenement {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateEvent;
    private String heure;
    private String lieu;
    //pseudo de celui qui a creer leveement privee
    private String pseudo;


    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "soiree_id")
    private Soiree soiree_int;


    public Evenement(String name, Date dateEvent, String heure, String lieu, String pseudo) {
        this.name = name;
        this.heure = heure;
        this.lieu = lieu;
        this.pseudo = pseudo;
        this.dateEvent = dateEvent;
    }

    public Evenement() {
    }

    public Soiree getSoiree_int() {
        return soiree_int;
    }

    public void setSoiree_int(Soiree soiree_int) {
        this.soiree_int = soiree_int;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}

