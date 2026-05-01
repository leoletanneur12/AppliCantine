package com.cantine;

import com.cantine.model.Cantine;
import com.cantine.ui.CanteineGUI;
import javax.swing.*;
import java.util.logging.*;
import java.io.IOException;

/**
 * Classe principale de l'application de gestion de cantine
 * Projet BTS SIO - École de Caux et Sauzens
 */
public class Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());
    
    public static void main(String[] args) {
        try {
            // Configuration des logs
            configureLogging();
            logger.log(Level.INFO, "=== Démarrage de l'application de gestion de cantine ===");
            logger.log(Level.INFO, "École de Caux et Sauzens");
            
            // Initialisation de la cantine
            Cantine cantine = new Cantine("Cantine de Caux et Sauzens");
            logger.log(Level.INFO, "Cantine initialisée avec succès");
            
            // Données de test
            ajouterDonneesTest(cantine);
            
            // Affichage de l'interface graphique
            SwingUtilities.invokeLater(() -> {
                CanteineGUI gui = new CanteineGUI(cantine);
                gui.setVisible(true);
                logger.log(Level.INFO, "Interface graphique affichée");
            });
            
        } catch (IOException e) {
            System.err.println("Erreur lors de la configuration des logs: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Configure le système de logging
     */
    private static void configureLogging() throws IOException {
        // Créer un gestionnaire de fichier pour les logs
        FileHandler fileHandler = new FileHandler("logs/cantine.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        
        // Créer un gestionnaire console
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new SimpleFormatter());
        
        // Configurer le logger root
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.INFO);
        rootLogger.addHandler(fileHandler);
        rootLogger.addHandler(consoleHandler);
    }
    
    /**
     * Ajoute des données de test à la cantine
     */
    private static void ajouterDonneesTest(Cantine cantine) {
        logger.log(Level.INFO, "Ajout des données de test");
        
        // Ajout de repas de test
        cantine.ajouterRepas(new com.cantine.model.Repas("Poulet rôti", 5.50, 20));
        cantine.ajouterRepas(new com.cantine.model.Repas("Steak frites", 6.00, 15));
        cantine.ajouterRepas(new com.cantine.model.Repas("Salade composée", 4.50, 25));
        cantine.ajouterRepas(new com.cantine.model.Repas("Pâtes carbonara", 5.00, 18));
        
        // Ajout d'élèves de test
        cantine.ajouterEleve(new com.cantine.model.Eleve("Dupont", "Jean", "E001", 20.00));
        cantine.ajouterEleve(new com.cantine.model.Eleve("Martin", "Marie", "E002", 15.50));
        cantine.ajouterEleve(new com.cantine.model.Eleve("Bernard", "Pierre", "E003", 25.00));
        
        logger.log(Level.INFO, "Données de test ajoutées avec succès");
        cantine.afficherStatistiques();
    }
}
