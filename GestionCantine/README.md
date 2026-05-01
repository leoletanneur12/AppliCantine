README - Gestion de Cantine
==========================

## Projet: Gestion de Cantine de l'École de Caux et Sauzens
**Type:** Projet BTS SIO  
**Date:** 2026

### Description
Application Java de gestion de cantine scolaire avec interface graphique Swing.
L'application utilise une architecture 100% orientée objet avec logging complet.

### Fonctionnalités Principales

1. **Gestion des élèves** ✓
   - Ajouter un élève (nom, prénom, matricule, solde initial)
   - Consulter la liste des élèves avec leurs soldes
   - Gérer le crédit (solde) des élèves

2. **Gestion des repas** ✓
   - Ajouter un repas (nom, prix, quantité disponible)
   - Consulter la liste des repas disponibles
   - Suivi de la quantité disponible

3. **Gestion des achats** ✓
   - Effectuer un achat (élève achète un repas)
   - Débiter le solde de l'élève
   - Réduire la quantité disponible du repas
   - Historique complet des achats

### Architecture

```
com.cantine/
├── Application.java         (Point d'entrée)
├── model/
│   ├── Cantine.java        (Classe métier principale)
│   ├── Eleve.java          (Classe élève)
│   ├── Repas.java          (Classe repas)
│   └── Achat.java          (Classe historique achat)
└── ui/
    ├── CanteineGUI.java    (Interface principale)
    ├── FenetreEleves.java  (Gestion élèves)
    ├── FenetreRepas.java   (Gestion repas)
    └── FenetreAchat.java   (Gestion achats)
```

### Technologies Utilisées
- **Langage:** Java 11+
- **Interface GUI:** Swing (Java standard library)
- **Logging:** java.util.logging
- **Build:** Maven

### Compilation et Exécution

#### Avec Maven:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.cantine.Application"
```

#### Créer un JAR exécutable:
```bash
mvn clean package
java -jar target/gestion-cantine-1.0.0.jar
```

#### Compilation manuelle (sans Maven):
```bash
# Compiler
javac -d bin src/main/java/com/cantine/**/*.java

# Exécuter
java -cp bin com.cantine.Application
```

### Données de Test
L'application démarre avec des données de test pré-chargées:
- 4 repas disponibles
- 3 élèves avec solde initial

### Logs
Les logs sont enregistrés dans le fichier `logs/cantine.log` et affichés en console.

### Points Clés POO
✓ Encapsulation: Getters/setters pour chaque classe
✓ Héritage: Classes spécialisées
✓ Polymorphisme: toString() surchargé
✓ Abstraction: Classes métier bien définies
✓ Logging complet: Chaque action est loggée

### Améliorations Possibles
- Ajouter une base de données (MySQL, SQLite)
- Système de rôles (admin, caissier, élève)
- Historique persistant
- Rapports financiers
- Interface web (JSP/Servlets)

---
**Auteur:** Étudiant BTS SIO  
**École:** Caux et Sauzens
