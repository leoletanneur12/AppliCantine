package com.cantine.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe représentant un achat effectué par un élève
 */
public class Achat {
    private Eleve eleve;
    private Repas repas;
    private LocalDateTime dateAchat;
    
    /**
     * Constructeur d'un achat
     * @param eleve L'élève effectuant l'achat
     * @param repas Le repas acheté
     */
    public Achat(Eleve eleve, Repas repas) {
        this.eleve = eleve;
        this.repas = repas;
        this.dateAchat = LocalDateTime.now();
    }
    
    public Eleve getEleve() {
        return eleve;
    }
    
    public Repas getRepas() {
        return repas;
    }
    
    public LocalDateTime getDateAchat() {
        return dateAchat;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateAchat.format(formatter) + " - " + eleve.getPrenom() + " " + eleve.getNom() 
            + " a acheté " + repas.getNom() + " pour " + repas.getPrix() + "€";
    }
}
