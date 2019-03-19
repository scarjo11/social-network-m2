package fr.orleans.miage.projet.groupeJ.microserviceclient.beans;

/**
 * Created by wilfrid on 17/03/2019.
 */
public class NotificationBean {
    private int id;
    private  String message;
    private String typeNotif;
    private String status ;
    private String pseudo;

    public NotificationBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeNotif() {
        return typeNotif;
    }

    public void setTypeNotif(String typeNotif) {
        this.typeNotif = typeNotif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
