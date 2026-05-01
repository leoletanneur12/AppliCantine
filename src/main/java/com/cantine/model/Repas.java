package com.cantine.model;

/**
 * Classe représentant un repas proposé à la cantine
 */
public class Repas {
    private String nom;
    private double prix;
    private int quantiteDisponible;
    
    /**
     * Constructeur d'un repas
     * @param nom Le nom du repas
     * @param prix Le prix du repas
     * @param quantiteDisponible La quantité disponible
     */
    public Repas(String nom, double prix, int quantiteDisponible) {
        this.nom = nom;
        this.prix = prix;
        this.quantiteDisponible = quantiteDisponible;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public double getPrix() {
        return prix;
    }
    
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }
    
    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }
    
    /**
     * Réduit la quantité disponible après achat
     * @param quantite La quantité à retirer
     * @return true si possible, false si quantité insuffisante
     */
    public boolean diminuerQuantite(int quantite) {
        if (this.quantiteDisponible >= quantite) {
            this.quantiteDisponible -= quantite;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return nom + " - " + prix + "€ (" + quantiteDisponible + " restants)";
    }
}
