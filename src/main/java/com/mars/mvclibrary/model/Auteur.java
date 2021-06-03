package com.mars.mvclibrary.model;

import java.io.Serializable;

public class Auteur implements Serializable {
    private int id;
    private String nom;
    private String premon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPremon() {
        return premon;
    }

    public void setPremon(String premon) {
        this.premon = premon;
    }
}