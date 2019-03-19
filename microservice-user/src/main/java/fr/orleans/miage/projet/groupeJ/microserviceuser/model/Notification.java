package fr.orleans.miage.projet.groupeJ.microserviceuser.model;

import java.util.Collection;
import javax.persistence.*;
/**
 * Created by wilfrid on 14/03/2019.
 */
@Entity
public class Notification {
    @Id
    @GeneratedValue
    private int id;
    private  String message;
    private String typeNotif;
    private String status ;

    //pseudo des user qui ont recu la botification
    //@ManyToMany
    //@ElementCollection
    private String pseudo;

    public Notification() {
    }

    public Notification(String message, String typeNotif) {
        this.message = message;
        this.status = "NON_LU";
       // this.pseudo = pseudo;
        this.typeNotif = typeNotif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeNotif() {
        return typeNotif;
    }

    public void setTypeNotif(String typeNotif) {
        this.typeNotif = typeNotif;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
/*
    public Collection<String> getPseudo() {
        return pseudo;
    }

    public void setPseudo(Collection<String> pseudo) {
        this.pseudo = pseudo;
    }
*/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
