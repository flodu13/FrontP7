package com.mars.mvclibrary.model;

public class OuvrageUtilisateur {

    Integer utilisateurId;
    Integer ouvrageId;

    public OuvrageUtilisateur(Integer utilisateurId, Integer ouvrageId) {
        this.utilisateurId = utilisateurId;
        this.ouvrageId = ouvrageId;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }
}