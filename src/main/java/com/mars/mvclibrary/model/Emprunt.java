package com.mars.mvclibrary.model;

import java.security.PrivateKey;
import java.util.Date;

public class Emprunt {

    private int id;

    private String dateRenduPrevu;
    private String datelimite;
    private String rendu;
    private Ouvrage ouvrage;

    private Boolean prolongPret;

    public Boolean getProlongPret() {
        return prolongPret;
    }

    public void setProlongPret(Boolean prolongPret) {
        this.prolongPret = prolongPret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateRenduPrevu() {
        return dateRenduPrevu;
    }

    public void setDateRenduPrevu(String dateRenduPrevu) {
        this.dateRenduPrevu = dateRenduPrevu;
    }

    public String getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(String datelimite) {
        this.datelimite = datelimite;
    }

    public String getRendu() {
        return rendu;
    }

    public void setRendu(String rendu) {
        this.rendu = rendu;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }
}
