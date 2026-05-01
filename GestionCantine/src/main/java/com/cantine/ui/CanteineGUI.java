package com.cantine.ui;

import com.cantine.model.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Interface graphique principale de la gestion de cantine
 */
public class CanteineGUI extends JFrame {
    private static final Logger logger = Logger.getLogger(CanteineGUI.class.getName());
    private Cantine cantine;
    private JPanel mainPanel;
    
    /**
     * Constructeur de l'interface
     * @param cantine L'instance de cantine à gérer
     */
    public CanteineGUI(Cantine cantine) {
        this.cantine = cantine;
        logger.log(Level.INFO, "Initialisation de l'interface graphique");
        initializeUI();
    }
    
    /**
     * Initialise tous les composants de l'interface
     */
    private void initializeUI() {
        setTitle("Gestion de Cantine - École de Caux et Sauzens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Panneau d'en-tête
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Panneau central avec les boutons
        JPanel centerPanel = createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Panneau de pied de page
        JPanel footerPanel = createFooterPanel();
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        this.setContentPane(mainPanel);
        logger.log(Level.INFO, "Interface graphique initialisée avec succès");
    }
    
    /**
     * Crée le panneau d'en-tête
     */
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(52, 152, 219));
        panel.setPreferredSize(new Dimension(600, 60));
        
        JLabel title = new JLabel("Gestion de Cantine");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        
        panel.add(title);
        return panel;
    }
    
    /**
     * Crée le panneau central avec les boutons de fonctionnalités
     */
    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        // Bouton 1: Gérer les élèves
        JButton btnEleves = new JButton("👥 Gérer les élèves");
        btnEleves.setFont(new Font("Arial", Font.PLAIN, 14));
        btnEleves.addActionListener(e -> {
            logger.log(Level.INFO, "Ouverture du gestionnaire d'élèves");
            new FenetreEleves(cantine).setVisible(true);
        });
        panel.add(btnEleves);
        
        // Bouton 2: Gérer les repas
        JButton btnRepas = new JButton("🍽️ Gérer les repas");
        btnRepas.setFont(new Font("Arial", Font.PLAIN, 14));
        btnRepas.addActionListener(e -> {
            logger.log(Level.INFO, "Ouverture du gestionnaire de repas");
            new FenetreRepas(cantine).setVisible(true);
        });
        panel.add(btnRepas);
        
        // Bouton 3: Effectuer un achat
        JButton btnAchat = new JButton("💳 Effectuer un achat");
        btnAchat.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAchat.addActionListener(e -> {
            logger.log(Level.INFO, "Ouverture du gestionnaire d'achats");
            new FenetreAchat(cantine).setVisible(true);
        });
        panel.add(btnAchat);
        
        return panel;
    }
    
    /**
     * Crée le panneau de pied de page
     */
    private JPanel createFooterPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(189, 195, 199));
        panel.setPreferredSize(new Dimension(600, 30));
        
        JLabel footer = new JLabel("École de Caux et Sauzens - Application BTS SIO");
        footer.setFont(new Font("Arial", Font.ITALIC, 10));
        
        panel.add(footer);
        return panel;
    }
}
