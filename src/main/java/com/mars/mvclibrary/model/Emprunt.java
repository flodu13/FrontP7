package com.mars.mvclibrary.model;

import java.util.Date;

public class Emprunt {

    private int id;

    private Date dateRenduPrevu;
    private Date datelimite;
    private Date rendu;
    private int ouvrageID;
    private int utilisateurId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateRenduPrevu() {
        return dateRenduPrevu;
    }

    public void setDateRenduPrevu(Date dateRenduPrevu) {
        this.dateRenduPrevu = dateRenduPrevu;
    }

    public Date getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(Date datelimite) {
        this.datelimite = datelimite;
    }

    public Date getRendu() {
        return rendu;
    }

    public void setRendu(Date rendu) {
        this.rendu = rendu;
    }

    public int getOuvrageID() {
        return ouvrageID;
    }

    public void setOuvrageID(int ouvrageID) {
        this.ouvrageID = ouvrageID;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
