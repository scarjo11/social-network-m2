package fr.orleans.miage.projet.groupeJ.microservicesoiree.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by wilfrid on 06/03/2019.
 */
@Entity
public class EvenementOpenData {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEvent;
    private String heure;
    private String lieu;
    private String lien ;

    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "soiree_id")
    private Collection<Soiree> soiree_ext;


    public EvenementOpenData(String name, Date dateEvent, String heure, String lieu, String lien) {
        this.name = name;
        this.heure = heure;
        this.lieu = lieu;
        this.lien = lien;
        this.dateEvent = dateEvent;
    }

    public EvenementOpenData() {
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Collection<Soiree> getSoiree_ext() {
        return soiree_ext;
    }

    public void setSoiree_ext(Collection<Soiree> soiree_ext) {
        this.soiree_ext = soiree_ext;
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

