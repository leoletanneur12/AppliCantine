package com.cantine.model;

/**
 * Classe représentant un élève de l'école
 */
public class Eleve {
    private String nom;
    private String prenom;
    private String matricule;
    private double solde;
    
    /**
     * Constructeur d'un élève
     * @param nom Le nom de famille de l'élève
     * @param prenom Le prénom de l'élève
     * @param matricule Le numéro matricule unique
     * @param solde Le solde initial
     */
    public Eleve(String nom, String prenom, String matricule, double solde) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.solde = solde;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getMatricule() {
        return matricule;
    }
    
    public double getSolde() {
        return solde;
    }
    
    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    /**
     * Crédite le solde de l'élève
     * @param montant Le montant à créditer
     */
    public void crediter(double montant) {
        this.solde += montant;
    }
    
    /**
     * Débite le solde de l'élève
     * @param montant Le montant à débiter
     * @return true si possible, false si solde insuffisant
     */
    public boolean debiter(double montant) {
        if (this.solde >= montant) {
            this.solde -= montant;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return prenom + " " + nom + " (ID: " + matricule + ") - Solde: " + solde + "€";
    }
}
