package com.cantine.ui;

import com.cantine.model.Cantine;
import com.cantine.model.Eleve;
import com.cantine.model.Repas;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Fenêtre pour effectuer un achat
 */
public class FenetreAchat extends JFrame {
    private static final Logger logger = Logger.getLogger(FenetreAchat.class.getName());
    private Cantine cantine;
    private JTextArea historiquArea;
    private JComboBox<String> eleveCombo;
    private JComboBox<String> repasCombo;
    
    public FenetreAchat(Cantine cantine) {
        this.cantine = cantine;
        logger.log(Level.INFO, "Ouverture de la fenêtre d'achat");
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Effectuer un Achat");
        setSize(550, 450);
        setLocationRelativeTo(null);
        setResizable(true);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panneau d'achat
        JPanel buyPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        buyPanel.setBorder(BorderFactory.createTitledBorder("Effectuer un achat"));
        
        JLabel eleveLabel = new JLabel("Sélectionner un élève:");
        eleveCombo = new JComboBox<>();
        remplirComboEleves();
        
        JLabel repasLabel = new JLabel("Sélectionner un repas:");
        repasCombo = new JComboBox<>();
        remplirComboRepas();
        
        JButton btnAcheter = new JButton("Acheter");
        btnAcheter.setFont(new Font("Arial", Font.BOLD, 12));
        btnAcheter.addActionListener(e -> effectuerAchat());
        
        buyPanel.add(eleveLabel);
        buyPanel.add(eleveCombo);
        buyPanel.add(repasLabel);
        buyPanel.add(repasCombo);
        buyPanel.add(new JLabel());
        buyPanel.add(btnAcheter);
        
        // Zone d'affichage de l'historique
        historiquArea = new JTextArea();
        historiquArea.setEditable(false);
        historiquArea.setFont(new Font("Courier", Font.PLAIN, 10));
        JScrollPane scrollPane = new JScrollPane(historiquArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Historique des achats"));
        
        mainPanel.add(buyPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        this.setContentPane(mainPanel);
        updateHistorique();
    }
    
    private void remplirComboEleves() {
        eleveCombo.removeAllItems();
        if (cantine.getEleves().isEmpty()) {
            eleveCombo.addItem("Aucun élève");
        } else {
            for (Eleve e : cantine.getEleves()) {
                eleveCombo.addItem(e.getMatricule() + " - " + e.getPrenom() + " " + e.getNom());
            }
        }
    }
    
    private void remplirComboRepas() {
        repasCombo.removeAllItems();
        if (cantine.getRepas().isEmpty()) {
            repasCombo.addItem("Aucun repas");
        } else {
            for (Repas r : cantine.getRepas()) {
                repasCombo.addItem(r.getNom() + " - " + r.getPrix() + "€");
            }
        }
    }
    
    private void effectuerAchat() {
        if (cantine.getEleves().isEmpty() || cantine.getRepas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez d'abord ajouter un élève et un repas!", 
                "Erreur", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.WARNING, "Tentative d'achat sans élève ou repas disponible");
            return;
        }
        
        int indexEleve = eleveCombo.getSelectedIndex();
        int indexRepas = repasCombo.getSelectedIndex();
        
        if (indexEleve >= 0 && indexRepas >= 0) {
            Eleve eleve = cantine.getEleves().get(indexEleve);
            Repas repas = cantine.getRepas().get(indexRepas);
            
            if (cantine.enregistrerAchat(eleve, repas)) {
                JOptionPane.showMessageDialog(this, "Achat réussi!\n" 
                    + eleve.getPrenom() + " a acheté " + repas.getNom() 
                    + " pour " + repas.getPrix() + "€\nNouveau solde: " + eleve.getSolde() + "€", 
                    "Succès", JOptionPane.INFORMATION_MESSAGE);
                logger.log(Level.INFO, "Achat effectué avec succès");
            } else {
                JOptionPane.showMessageDialog(this, "Achat échoué!\nSolde insuffisant ou repas indisponible.", 
                    "Erreur", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.WARNING, "Achat échoué");
            }
            
            remplirComboRepas();
            updateHistorique();
        }
    }
    
    private void updateHistorique() {
        StringBuilder sb = new StringBuilder();
        if (cantine.getHistorique().isEmpty()) {
            sb.append("Aucun achat enregistré.");
        } else {
            for (com.cantine.model.Achat achat : cantine.getHistorique()) {
                sb.append(achat.toString()).append("\n");
            }
        }
        historiquArea.setText(sb.toString());
    }
}
