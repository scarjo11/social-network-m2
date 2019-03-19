package fr.orleans.miage.projet.groupeJ.microserviceclient.beans;

import java.util.Collection;
import java.util.Date;

/**
 * Created by wilfrid on 17/03/2019.
 */
public class EvenementOpenDataBean {
    private long id;
    private String name;
    private Date dateEvent;
    private String heure;
    private String lieu;
    private String lien ;

    private Collection<SoireeBean> soiree_ext;

    public EvenementOpenDataBean() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Collection<SoireeBean> getSoiree_ext() {
        return soiree_ext;
    }

    public void setSoiree_ext(Collection<SoireeBean> soiree_ext) {
        this.soiree_ext = soiree_ext;
    }
}

