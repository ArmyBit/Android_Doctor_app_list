package com.isga.isgaexam;

public class Medecin {
    private int Code_Medecin;
    private  String Nom_Medecin,Prenom_Medecin,Specialite_Medecin,Ville_Medecin,Description_Medecin;
    public Medecin(){}
    public Medecin(String nom_Medecin, String prenom_Medecin, String specialite_Medecin, String ville_Medecin, String description_Medecin) {
        Nom_Medecin = nom_Medecin;
        Prenom_Medecin = prenom_Medecin;
        Specialite_Medecin = specialite_Medecin;
        Ville_Medecin = ville_Medecin;
        Description_Medecin = description_Medecin;
    }

    public Medecin(int code_Medecin, String nom_Medecin, String prenom_Medecin, String specialite_Medecin, String ville_Medecin, String description_Medecin) {
        Code_Medecin = code_Medecin;
        Nom_Medecin = nom_Medecin;
        Prenom_Medecin = prenom_Medecin;
        Specialite_Medecin = specialite_Medecin;
        Ville_Medecin = ville_Medecin;
        Description_Medecin = description_Medecin;
    }

    public String getNom_Medecin() {
        return Nom_Medecin;
    }

    public void setNom_Medecin(String nom_Medecin) {
        Nom_Medecin = nom_Medecin;
    }

    public int getCode_Medecin() {
        return Code_Medecin;
    }

    public void setCode_Medecin(int code_Medecin) {
        Code_Medecin = code_Medecin;
    }

    public String getPrenom_Medecin() {
        return Prenom_Medecin;
    }

    public void setPrenom_Medecin(String prenom_Medecin) {
        Prenom_Medecin = prenom_Medecin;
    }

    public String getSpecialite_Medecin() {
        return Specialite_Medecin;
    }

    public void setSpecialite_Medecin(String specialite_Medecin) {
        Specialite_Medecin = specialite_Medecin;
    }

    public String getVille_Medecin() {
        return Ville_Medecin;
    }

    public void setVille_Medecin(String ville_Medecin) {
        Ville_Medecin = ville_Medecin;
    }

    public String getDescription_Medecin() {
        return Description_Medecin;
    }

    public void setDescription_Medecin(String description_Medecin) {
        Description_Medecin = description_Medecin;
    }
}
