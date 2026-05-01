package com.cantine.ui;

import com.cantine.model.Cantine;
import com.cantine.model.Eleve;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Fenêtre de gestion des élèves
 */
public class FenetreEleves extends JFrame {
    private static final Logger logger = Logger.getLogger(FenetreEleves.class.getName());
    private Cantine cantine;
    private JTextArea textArea;
    
    public FenetreEleves(Cantine cantine) {
        this.cantine = cantine;
        logger.log(Level.INFO, "Ouverture de la fenêtre de gestion des élèves");
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Gestion des Élèves");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panneau d'ajout
        JPanel addPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        addPanel.setBorder(BorderFactory.createTitledBorder("Ajouter un élève"));
        
        JLabel nomLabel = new JLabel("Nom:");
        JTextField nomField = new JTextField();
        
        JLabel prenomLabel = new JLabel("Prénom:");
        JTextField prenomField = new JTextField();
        
        JLabel matriculeLabel = new JLabel("Matricule:");
        JTextField matriculeField = new JTextField();
        
        JLabel soldeLabel = new JLabel("Solde initial (€):");
        JTextField soldeField = new JTextField();
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(e -> {
            try {
                String nom = nomField.getText().trim();
                String prenom = prenomField.getText().trim();
                String matricule = matriculeField.getText().trim();
                double solde = Double.parseDouble(soldeField.getText().trim());
                
                if (nom.isEmpty() || prenom.isEmpty() || matricule.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires!", 
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                    logger.log(Level.WARNING, "Tentative d'ajout d'élève avec champs vides");
                    return;
                }
                
                Eleve eleve = new Eleve(nom, prenom, matricule, solde);
                cantine.ajouterEleve(eleve);
                
                nomField.setText("");
                prenomField.setText("");
                matriculeField.setText("");
                soldeField.setText("");
                
                JOptionPane.showMessageDialog(this, "Élève ajouté avec succès!", 
                    "Succès", JOptionPane.INFORMATION_MESSAGE);
                logger.log(Level.INFO, "Élève ajouté: " + prenom + " " + nom);
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Le solde doit être un nombre!", 
                    "Erreur", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.WARNING, "Format de solde invalide");
            }
        });
        
        addPanel.add(nomLabel);
        addPanel.add(nomField);
        addPanel.add(prenomLabel);
        addPanel.add(prenomField);
        addPanel.add(matriculeLabel);
        addPanel.add(matriculeField);
        addPanel.add(soldeLabel);
        addPanel.add(soldeField);
        addPanel.add(btnAjouter);
        
        // Zone d'affichage des élèves
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier", Font.PLAIN, 11));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des élèves"));
        
        mainPanel.add(addPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        this.setContentPane(mainPanel);
        updateDisplay();
    }
    
    private void updateDisplay() {
        StringBuilder sb = new StringBuilder();
        if (cantine.getEleves().isEmpty()) {
            sb.append("Aucun élève enregistré.");
        } else {
            for (Eleve e : cantine.getEleves()) {
                sb.append(e.toString()).append("\n");
            }
        }
        textArea.setText(sb.toString());
        logger.log(Level.INFO, "Affichage mis à jour: " + cantine.getEleves().size() + " élèves");
    }
}
