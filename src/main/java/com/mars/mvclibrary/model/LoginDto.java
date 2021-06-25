package com.mars.mvclibrary.model;

public class LoginDto {

    String nom;
    String motDePasse;


    public LoginDto(String nom, String motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        motDePasse = motDePasse;
    }
}
