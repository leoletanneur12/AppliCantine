package com.cantine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Classe métier principale pour la gestion de la cantine
 */
public class Cantine {
    private static final Logger logger = Logger.getLogger(Cantine.class.getName());
    private String nom;
    private List<Repas> repas;
    private List<Eleve> eleves;
    private List<Achat> historique;
    
    /**
     * Constructeur de la cantine
     * @param nom Le nom de la cantine
     */
    public Cantine(String nom) {
        this.nom = nom;
        this.repas = new ArrayList<>();
        this.eleves = new ArrayList<>();
        this.historique = new ArrayList<>();
        logger.log(Level.INFO, "Cantine " + nom + " initialisée");
    }
    
    public String getNom() {
        return nom;
    }
    
    public List<Repas> getRepas() {
        return repas;
    }
    
    public List<Eleve> getEleves() {
        return eleves;
    }
    
    public List<Achat> getHistorique() {
        return historique;
    }
    
    /**
     * Ajoute un repas à la cantine
     * @param repas Le repas à ajouter
     */
    public void ajouterRepas(Repas repas) {
        this.repas.add(repas);
        logger.log(Level.INFO, "Repas ajouté: " + repas.getNom() + " - " + repas.getPrix() + "€");
    }
    
    /**
     * Ajoute un élève à la cantine
     * @param eleve L'élève à ajouter
     */
    public void ajouterEleve(Eleve eleve) {
        this.eleves.add(eleve);
        logger.log(Level.INFO, "Élève ajouté: " + eleve.getPrenom() + " " + eleve.getNom());
    }
    
    /**
     * Enregistre un achat dans l'historique
     * @param eleve L'élève qui achète
     * @param repas Le repas acheté
     * @return true si l'achat est réussi, false sinon
     */
    public boolean enregistrerAchat(Eleve eleve, Repas repas) {
        if (repas.diminuerQuantite(1) && eleve.debiter(repas.getPrix())) {
            Achat achat = new Achat(eleve, repas);
            historique.add(achat);
            logger.log(Level.INFO, "Achat enregistré: " + eleve.getPrenom() + " " + eleve.getNom() 
                + " a acheté " + repas.getNom());
            return true;
        } else {
            logger.log(Level.WARNING, "Achat échoué pour " + eleve.getPrenom() + " " + eleve.getNom() 
                + " - Solde insuffisant ou repas indisponible");
            return false;
        }
    }
    
    /**
     * Crédite le solde d'un élève
     * @param matricule Le matricule de l'élève
     * @param montant Le montant à créditer
     * @return true si l'opération réussit
     */
    public boolean crediterEleve(String matricule, double montant) {
        for (Eleve e : eleves) {
            if (e.getMatricule().equals(matricule)) {
                e.crediter(montant);
                logger.log(Level.INFO, "Crédit appliqué: " + montant + "€ pour " + e.getPrenom() + " " + e.getNom());
                return true;
            }
        }
        logger.log(Level.WARNING, "Élève avec matricule " + matricule + " non trouvé");
        return false;
    }
    
    /**
     * Récupère un élève par son matricule
     * @param matricule Le matricule à rechercher
     * @return L'élève trouvé ou null
     */
    public Eleve obtenirEleve(String matricule) {
        for (Eleve e : eleves) {
            if (e.getMatricule().equals(matricule)) {
                return e;
            }
        }
        return null;
    }
    
    /**
     * Affiche les statistiques de la cantine
     */
    public void afficherStatistiques() {
        logger.log(Level.INFO, "===== Statistiques de la cantine =====");
        logger.log(Level.INFO, "Nombre d'élèves: " + eleves.size());
        logger.log(Level.INFO, "Nombre de repas disponibles: " + repas.size());
        logger.log(Level.INFO, "Historique des achats: " + historique.size());
    }
}
