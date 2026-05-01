package com.cantine.model;

/**
 * Classe de tests unitaires pour la cantine
 * Exemple de tests POO pour le projet BTS
 * 
 * Note: Pour utiliser ces tests, installer JUnit 4:
 * - Ajouter une dépendance Maven: junit:junit:4.13.2
 * - Ou ajouter junit-4.13.2.jar au classpath
 */
public class TestCantine {
    
    // ===== TESTS POUR CLASSE ELEVE =====
    
    /**
     * Test de création d'un élève
     */
    public static void testCreationEleve() {
        System.out.println("TEST: Création d'élève");
        Eleve e = new Eleve("Dupont", "Jean", "E001", 20.0);
        
        assert e.getNom().equals("Dupont") : "Nom incorrect";
        assert e.getPrenom().equals("Jean") : "Prénom incorrect";
        assert e.getMatricule().equals("E001") : "Matricule incorrect";
        assert e.getSolde() == 20.0 : "Solde incorrect";
        
        System.out.println("✓ Élève créé avec succès");
    }
    
    /**
     * Test du débit d'un élève
     */
    public static void testDebitEleve() {
        System.out.println("TEST: Débit d'élève");
        Eleve e = new Eleve("Martin", "Marie", "E002", 50.0);
        
        // Débit valide
        boolean resultat1 = e.debiter(10.0);
        assert resultat1 == true : "Débit devrait réussir";
        assert e.getSolde() == 40.0 : "Solde devrait être 40€";
        
        // Débit supérieur au solde
        boolean resultat2 = e.debiter(50.0);
        assert resultat2 == false : "Débit devrait échouer";
        assert e.getSolde() == 40.0 : "Solde ne devrait pas changer";
        
        System.out.println("✓ Débit fonctionne correctement");
    }
    
    /**
     * Test du crédit d'un élève
     */
    public static void testCreditEleve() {
        System.out.println("TEST: Crédit d'élève");
        Eleve e = new Eleve("Bernard", "Pierre", "E003", 20.0);
        
        e.crediter(15.0);
        assert e.getSolde() == 35.0 : "Solde devrait être 35€";
        
        e.crediter(5.5);
        assert e.getSolde() == 40.5 : "Solde devrait être 40.5€";
        
        System.out.println("✓ Crédit fonctionne correctement");
    }
    
    // ===== TESTS POUR CLASSE REPAS =====
    
    /**
     * Test de création d'un repas
     */
    public static void testCreationRepas() {
        System.out.println("TEST: Création de repas");
        Repas r = new Repas("Poulet rôti", 5.50, 20);
        
        assert r.getNom().equals("Poulet rôti") : "Nom incorrect";
        assert r.getPrix() == 5.50 : "Prix incorrect";
        assert r.getQuantiteDisponible() == 20 : "Quantité incorrecte";
        
        System.out.println("✓ Repas créé avec succès");
    }
    
    /**
     * Test de diminution de quantité
     */
    public static void testDiminuerQuantite() {
        System.out.println("TEST: Diminution de quantité");
        Repas r = new Repas("Steak frites", 6.00, 10);
        
        // Diminution valide
        boolean resultat1 = r.diminuerQuantite(3);
        assert resultat1 == true : "Diminution devrait réussir";
        assert r.getQuantiteDisponible() == 7 : "Quantité devrait être 7";
        
        // Diminution supérieure à la quantité
        boolean resultat2 = r.diminuerQuantite(10);
        assert resultat2 == false : "Diminution devrait échouer";
        assert r.getQuantiteDisponible() == 7 : "Quantité ne devrait pas changer";
        
        System.out.println("✓ Diminution de quantité fonctionne");
    }
    
    // ===== TESTS POUR CLASSE CANTINE =====
    
    /**
     * Test d'ajout d'élève à la cantine
     */
    public static void testAjoutEleveCantine() {
        System.out.println("TEST: Ajout d'élève à la cantine");
        Cantine c = new Cantine("Test Cantine");
        
        assert c.getEleves().size() == 0 : "Cantine devrait être vide";
        
        Eleve e1 = new Eleve("Dupont", "Jean", "E001", 20.0);
        c.ajouterEleve(e1);
        assert c.getEleves().size() == 1 : "Un élève devrait être présent";
        
        Eleve e2 = new Eleve("Martin", "Marie", "E002", 25.0);
        c.ajouterEleve(e2);
        assert c.getEleves().size() == 2 : "Deux élèves devraient être présents";
        
        System.out.println("✓ Ajout d'élève fonctionne correctement");
    }
    
    /**
     * Test d'ajout de repas à la cantine
     */
    public static void testAjoutRepasCantine() {
        System.out.println("TEST: Ajout de repas à la cantine");
        Cantine c = new Cantine("Test Cantine");
        
        assert c.getRepas().size() == 0 : "Cantine devrait être vide";
        
        Repas r1 = new Repas("Poulet", 5.50, 20);
        c.ajouterRepas(r1);
        assert c.getRepas().size() == 1 : "Un repas devrait être présent";
        
        Repas r2 = new Repas("Steak", 6.00, 15);
        c.ajouterRepas(r2);
        assert c.getRepas().size() == 2 : "Deux repas devraient être présents";
        
        System.out.println("✓ Ajout de repas fonctionne correctement");
    }
    
    /**
     * Test d'achat réussi
     */
    public static void testAchatReussi() {
        System.out.println("TEST: Achat réussi");
        Cantine c = new Cantine("Test Cantine");
        
        Eleve e = new Eleve("Dupont", "Jean", "E001", 20.0);
        Repas r = new Repas("Poulet", 5.50, 10);
        
        c.ajouterEleve(e);
        c.ajouterRepas(r);
        
        assert c.getHistorique().size() == 0 : "Historique devrait être vide";
        
        boolean resultat = c.enregistrerAchat(e, r);
        assert resultat == true : "Achat devrait réussir";
        assert e.getSolde() == 14.50 : "Solde devrait être réduit";
        assert r.getQuantiteDisponible() == 9 : "Quantité devrait être réduite";
        assert c.getHistorique().size() == 1 : "Historique devrait avoir 1 achat";
        
        System.out.println("✓ Achat réussi enregistré correctement");
    }
    
    /**
     * Test d'achat échoué (solde insuffisant)
     */
    public static void testAchatEchoueSoldeInsuffisant() {
        System.out.println("TEST: Achat échoué (solde insuffisant)");
        Cantine c = new Cantine("Test Cantine");
        
        Eleve e = new Eleve("Martin", "Marie", "E002", 3.0);  // Solde faible
        Repas r = new Repas("Steak", 6.00, 10);
        
        c.ajouterEleve(e);
        c.ajouterRepas(r);
        
        boolean resultat = c.enregistrerAchat(e, r);
        assert resultat == false : "Achat devrait échouer";
        assert e.getSolde() == 3.0 : "Solde ne devrait pas changer";
        assert r.getQuantiteDisponible() == 10 : "Quantité ne devrait pas changer";
        assert c.getHistorique().size() == 0 : "Historique devrait rester vide";
        
        System.out.println("✓ Achat échoué géré correctement");
    }
    
    /**
     * Test de crédit d'élève via la cantine
     */
    public static void testCreditViaCanite() {
        System.out.println("TEST: Crédit d'élève via la cantine");
        Cantine c = new Cantine("Test Cantine");
        
        Eleve e = new Eleve("Bernard", "Pierre", "E003", 10.0);
        c.ajouterEleve(e);
        
        boolean resultat = c.crediterEleve("E003", 15.0);
        assert resultat == true : "Crédit devrait réussir";
        assert e.getSolde() == 25.0 : "Solde devrait être 25€";
        
        // Crédit avec matricule inexistant
        boolean resultat2 = c.crediterEleve("E999", 10.0);
        assert resultat2 == false : "Crédit avec ID invalide devrait échouer";
        
        System.out.println("✓ Crédit via cantine fonctionne");
    }
    
    /**
     * Test de recherche d'élève
     */
    public static void testRechercheEleve() {
        System.out.println("TEST: Recherche d'élève");
        Cantine c = new Cantine("Test Cantine");
        
        Eleve e1 = new Eleve("Dupont", "Jean", "E001", 20.0);
        Eleve e2 = new Eleve("Martin", "Marie", "E002", 25.0);
        
        c.ajouterEleve(e1);
        c.ajouterEleve(e2);
        
        Eleve trouve = c.obtenirEleve("E001");
        assert trouve != null : "Élève devrait être trouvé";
        assert trouve.getPrenom().equals("Jean") : "Prénom incorrect";
        
        Eleve nonTrouve = c.obtenirEleve("E999");
        assert nonTrouve == null : "Élève ne devrait pas être trouvé";
        
        System.out.println("✓ Recherche d'élève fonctionne");
    }
    
    // ===== TESTS POUR CLASSE ACHAT =====
    
    /**
     * Test de création d'achat
     */
    public static void testCreationAchat() {
        System.out.println("TEST: Création d'achat");
        Eleve e = new Eleve("Dupont", "Jean", "E001", 20.0);
        Repas r = new Repas("Poulet", 5.50, 20);
        
        Achat a = new Achat(e, r);
        assert a.getEleve() == e : "Élève incorrect";
        assert a.getRepas() == r : "Repas incorrect";
        assert a.getDateAchat() != null : "Date ne devrait pas être null";
        
        System.out.println("✓ Achat créé avec succès");
    }
    
    // ===== MAIN POUR EXÉCUTER TOUS LES TESTS =====
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("TESTS UNITAIRES - GESTION DE CANTINE");
        System.out.println("========================================\n");
        
        try {
            // Tests Eleve
            testCreationEleve();
            testDebitEleve();
            testCreditEleve();
            
            // Tests Repas
            testCreationRepas();
            testDiminuerQuantite();
            
            // Tests Cantine
            testAjoutEleveCantine();
            testAjoutRepasCantine();
            testAchatReussi();
            testAchatEchoueSoldeInsuffisant();
            testCreditViaCanite();
            testRechercheEleve();
            
            // Tests Achat
            testCreationAchat();
            
            System.out.println("\n========================================");
            System.out.println("✅ TOUS LES TESTS ONT RÉUSSI!");
            System.out.println("========================================");
            
        } catch (AssertionError e) {
            System.out.println("\n❌ TEST ÉCHOUÉ: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
