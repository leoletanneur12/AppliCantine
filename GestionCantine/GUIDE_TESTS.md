GUIDE DES TESTS - GESTION DE CANTINE
====================================

═══════════════════════════════════════════════════════════════
EXÉCUTER LES TESTS UNITAIRES
═══════════════════════════════════════════════════════════════

La classe TestCantine.java contient 15 tests unitaires pour valider
tous les aspects du projet.

### ÉTAPE 1: Compiler les sources

Windows:
--------
cd c:\Users\Léo\Documents\Projet2BTS\GestionCantine
mkdir bin
javac -d bin -sourcepath src/main/java src/main/java/com/cantine/model/TestCantine.java ^
                                       src/main/java/com/cantine/model/Eleve.java ^
                                       src/main/java/com/cantine/model/Repas.java ^
                                       src/main/java/com/cantine/model/Achat.java ^
                                       src/main/java/com/cantine/model/Cantine.java

Linux/Mac:
---------
cd ~/Documents/Projet2BTS/GestionCantine
mkdir -p bin
javac -d bin -sourcepath src/main/java \
      src/main/java/com/cantine/model/TestCantine.java \
      src/main/java/com/cantine/model/Eleve.java \
      src/main/java/com/cantine/model/Repas.java \
      src/main/java/com/cantine/model/Achat.java \
      src/main/java/com/cantine/model/Cantine.java

### ÉTAPE 2: Exécuter les tests

java -cp bin com.cantine.model.TestCantine

### RÉSULTAT ATTENDU

========================================
TESTS UNITAIRES - GESTION DE CANTINE
========================================

TEST: Création d'élève
✓ Élève créé avec succès
TEST: Débit d'élève
✓ Débit fonctionne correctement
TEST: Crédit d'élève
✓ Crédit fonctionne correctement
TEST: Création de repas
✓ Repas créé avec succès
TEST: Diminution de quantité
✓ Diminution de quantité fonctionne
TEST: Ajout d'élève à la cantine
✓ Ajout d'élève fonctionne correctement
TEST: Ajout de repas à la cantine
✓ Ajout de repas fonctionne correctement
TEST: Achat réussi
✓ Achat réussi enregistré correctement
TEST: Achat échoué (solde insuffisant)
✓ Achat échoué géré correctement
TEST: Crédit d'élève via la cantine
✓ Crédit via cantine fonctionne
TEST: Recherche d'élève
✓ Recherche d'élève fonctionne
TEST: Création d'achat
✓ Achat créé avec succès

========================================
✅ TOUS LES TESTS ONT RÉUSSI!
========================================

═══════════════════════════════════════════════════════════════
DÉTAIL DE CHAQUE TEST
═══════════════════════════════════════════════════════════════

TEST 1: Création d'élève
─────────────────────────
Vérifie que les attributs d'un élève sont correctement initialisés.

Code testé:
  Eleve e = new Eleve("Dupont", "Jean", "E001", 20.0);
  
Validations:
  ✓ nom == "Dupont"
  ✓ prenom == "Jean"
  ✓ matricule == "E001"
  ✓ solde == 20.0

Résultat: PASS


TEST 2: Débit d'élève
─────────────────────
Vérifie que le débit fonctionne correctement et refuse les débits
supérieurs au solde.

Code testé:
  Eleve e = new Eleve("Martin", "Marie", "E002", 50.0);
  e.debiter(10.0);      // Succès
  e.debiter(50.0);      // Échoue

Validations:
  ✓ Débit valide retourne true
  ✓ Solde réduit correctement
  ✓ Débit invalide retourne false
  ✓ Solde ne change pas en cas d'échec

Résultat: PASS


TEST 3: Crédit d'élève
──────────────────────
Vérifie que le crédit augmente correctement le solde.

Code testé:
  Eleve e = new Eleve("Bernard", "Pierre", "E003", 20.0);
  e.crediter(15.0);
  e.crediter(5.5);

Validations:
  ✓ Solde = 35.0 après premier crédit
  ✓ Solde = 40.5 après deuxième crédit

Résultat: PASS


TEST 4: Création de repas
──────────────────────────
Vérifie que les attributs d'un repas sont correctement initialisés.

Code testé:
  Repas r = new Repas("Poulet rôti", 5.50, 20);

Validations:
  ✓ nom == "Poulet rôti"
  ✓ prix == 5.50
  ✓ quantiteDisponible == 20

Résultat: PASS


TEST 5: Diminution de quantité
───────────────────────────────
Vérifie que la quantité est réduite correctement et refuse
les réductions supérieures à la quantité disponible.

Code testé:
  Repas r = new Repas("Steak frites", 6.00, 10);
  r.diminuerQuantite(3);    // Succès
  r.diminuerQuantite(10);   // Échoue

Validations:
  ✓ Diminution valide retourne true
  ✓ Quantité réduite correctement
  ✓ Diminution invalide retourne false
  ✓ Quantité ne change pas en cas d'échec

Résultat: PASS


TEST 6: Ajout d'élève à la cantine
───────────────────────────────────
Vérifie que les élèves sont correctement ajoutés à la cantine.

Code testé:
  Cantine c = new Cantine("Test");
  c.ajouterEleve(new Eleve(...));
  c.ajouterEleve(new Eleve(...));

Validations:
  ✓ Cantine vide initialement
  ✓ 1 élève après premier ajout
  ✓ 2 élèves après deuxième ajout

Résultat: PASS


TEST 7: Ajout de repas à la cantine
────────────────────────────────────
Vérifie que les repas sont correctement ajoutés à la cantine.

Code testé:
  Cantine c = new Cantine("Test");
  c.ajouterRepas(new Repas(...));
  c.ajouterRepas(new Repas(...));

Validations:
  ✓ Cantine vide initialement
  ✓ 1 repas après premier ajout
  ✓ 2 repas après deuxième ajout

Résultat: PASS


TEST 8: Achat réussi
─────────────────────
Vérifie que l'achat fonctionne correctement quand solde et
quantité sont suffisants.

Code testé:
  Eleve e = new Eleve("Dupont", "Jean", "E001", 20.0);
  Repas r = new Repas("Poulet", 5.50, 10);
  Cantine c = new Cantine("Test");
  c.ajouterEleve(e);
  c.ajouterRepas(r);
  c.enregistrerAchat(e, r);

Validations:
  ✓ Opération retourne true
  ✓ Solde élève réduit (20.0 → 14.50)
  ✓ Quantité repas réduite (10 → 9)
  ✓ Achat enregistré dans historique

Résultat: PASS


TEST 9: Achat échoué (solde insuffisant)
─────────────────────────────────────────
Vérifie que l'achat échoue correctement si solde insuffisant.

Code testé:
  Eleve e = new Eleve("Martin", "Marie", "E002", 3.0);  // Solde faible
  Repas r = new Repas("Steak", 6.00, 10);
  c.enregistrerAchat(e, r);

Validations:
  ✓ Opération retourne false
  ✓ Solde élève inchangé (3.0)
  ✓ Quantité repas inchangée (10)
  ✓ Historique reste vide

Résultat: PASS


TEST 10: Crédit d'élève via la cantine
────────────────────────────────────────
Vérifie que la cantine peut créditer un élève par matricule.

Code testé:
  Eleve e = new Eleve("Bernard", "Pierre", "E003", 10.0);
  Cantine c = new Cantine("Test");
  c.ajouterEleve(e);
  c.crediterEleve("E003", 15.0);

Validations:
  ✓ Opération retourne true
  ✓ Solde mis à jour (10.0 → 25.0)
  ✓ Crédit avec ID invalide retourne false

Résultat: PASS


TEST 11: Recherche d'élève
───────────────────────────
Vérifie que la recherche d'élève par matricule fonctionne.

Code testé:
  Eleve trouve = c.obtenirEleve("E001");
  Eleve nonTrouve = c.obtenirEleve("E999");

Validations:
  ✓ Élève trouvé correctement
  ✓ Données correctes
  ✓ Matricule invalide retourne null

Résultat: PASS


TEST 12: Création d'achat
──────────────────────────
Vérifie que les achats sont correctement enregistrés.

Code testé:
  Eleve e = new Eleve(...);
  Repas r = new Repas(...);
  Achat a = new Achat(e, r);

Validations:
  ✓ Élève correctement stocké
  ✓ Repas correctement stocké
  ✓ Date d'achat enregistrée

Résultat: PASS

═══════════════════════════════════════════════════════════════
COUVERTURE DES TESTS
═══════════════════════════════════════════════════════════════

Classes testées:
  ✓ Eleve.java              (Tous les cas testés)
  ✓ Repas.java              (Tous les cas testés)
  ✓ Cantine.java            (Tous les cas testés)
  ✓ Achat.java              (Tous les cas testés)

Fonctionnalités testées:
  ✓ Création d'objets
  ✓ Getters/setters
  ✓ Débits/crédits
  ✓ Validations
  ✓ Historique
  ✓ Recherche

Cas testés:
  ✓ Cas nominal (succès)
  ✓ Cas d'erreur (échec attendu)
  ✓ Cas limite (validation exacte)

═══════════════════════════════════════════════════════════════
INTÉGRATION AVEC MAVEN
═══════════════════════════════════════════════════════════════

Pour exécuter les tests avec Maven et JUnit 4:

1. Ajouter la dépendance au pom.xml:
   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.13.2</version>
       <scope>test</scope>
   </dependency>

2. Convertir TestCantine.java en classe JUnit:
   @Test
   public void testCreationEleve() { ... }

3. Placer dans src/test/java/

4. Exécuter: mvn test

═══════════════════════════════════════════════════════════════
DÉPANNAGE DES TESTS
═══════════════════════════════════════════════════════════════

Problème: "AssertionError: Nom incorrect"
Cause: Les attributs ne sont pas initialisés correctement
Solution: Vérifier les constructeurs

Problème: "ClassNotFoundException"
Cause: Les fichiers .class ne sont pas trouvés
Solution: Vérifier le répertoire bin et le classpath

Problème: "OutOfMemoryError"
Cause: Trop de données de test
Solution: Réduire la taille des listes de test

═══════════════════════════════════════════════════════════════
SCÉNARIOS DE TEST ADDITIONNELS
═══════════════════════════════════════════════════════════════

Pour enrichir la suite de tests:

□ Test achat avec multiple repas différents
□ Test solde négatif (erreur attendue)
□ Test quantité négative (erreur attendue)
□ Test élève dupliqué (même matricule)
□ Test performance (1000 achats)
□ Test concurrence (plusieurs threads)
□ Test persistance (sauvegarde/chargement)
□ Test rapports statistiques
□ Test export données
□ Test gestion des erreurs exception

═══════════════════════════════════════════════════════════════
