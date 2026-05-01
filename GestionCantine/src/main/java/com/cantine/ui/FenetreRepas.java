package com.cantine.ui;

import com.cantine.model.Cantine;
import com.cantine.model.Repas;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Fenêtre de gestion des repas
 */
public class FenetreRepas extends JFrame {
    private static final Logger logger = Logger.getLogger(FenetreRepas.class.getName());
    private Cantine cantine;
    private JTextArea textArea;
    
    public FenetreRepas(Cantine cantine) {
        this.cantine = cantine;
        logger.log(Level.INFO, "Ouverture de la fenêtre de gestion des repas");
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Gestion des Repas");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panneau d'ajout
        JPanel addPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        addPanel.setBorder(BorderFactory.createTitledBorder("Ajouter un repas"));
        
        JLabel nomLabel = new JLabel("Nom du repas:");
        JTextField nomField = new JTextField();
        
        JLabel prixLabel = new JLabel("Prix (€):");
        JTextField prixField = new JTextField();
        
        JLabel quantiteLabel = new JLabel("Quantité disponible:");
        JTextField quantiteField = new JTextField();
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(e -> {
            try {
                String nom = nomField.getText().trim();
                double prix = Double.parseDouble(prixField.getText().trim());
                int quantite = Integer.parseInt(quantiteField.getText().trim());
                
                if (nom.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Le nom du repas est obligatoire!", 
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                    logger.log(Level.WARNING, "Tentative d'ajout de repas avec nom vide");
                    return;
                }
                
                Repas repas = new Repas(nom, prix, quantite);
                cantine.ajouterRepas(repas);
                
                nomField.setText("");
                prixField.setText("");
                quantiteField.setText("");
                
                JOptionPane.showMessageDialog(this, "Repas ajouté avec succès!", 
                    "Succès", JOptionPane.INFORMATION_MESSAGE);
                logger.log(Level.INFO, "Repas ajouté: " + nom);
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Le prix et la quantité doivent être des nombres!", 
                    "Erreur", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.WARNING, "Format invalide pour prix ou quantité");
            }
        });
        
        addPanel.add(nomLabel);
        addPanel.add(nomField);
        addPanel.add(prixLabel);
        addPanel.add(prixField);
        addPanel.add(quantiteLabel);
        addPanel.add(quantiteField);
        addPanel.add(btnAjouter);
        
        // Zone d'affichage des repas
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier", Font.PLAIN, 11));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des repas disponibles"));
        
        mainPanel.add(addPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        this.setContentPane(mainPanel);
        updateDisplay();
    }
    
    private void updateDisplay() {
        StringBuilder sb = new StringBuilder();
        if (cantine.getRepas().isEmpty()) {
            sb.append("Aucun repas enregistré.");
        } else {
            for (Repas r : cantine.getRepas()) {
                sb.append(r.toString()).append("\n");
            }
        }
        textArea.setText(sb.toString());
        logger.log(Level.INFO, "Affichage mis à jour: " + cantine.getRepas().size() + " repas");
    }
}
