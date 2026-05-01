# Gestion de Cantine - École de Caux et Sauzens

Projet BTS SIO - Application Java de gestion de cantine scolaire avec interface graphique Swing.

## 🚀 Démarrage Rapide

### Avec Maven (recommandé)
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.cantine.Application"
```

### Compilation manuelle
```bash
mkdir -p bin
javac -d bin -sourcepath src/main/java src/main/java/com/cantine/**/*.java
java -cp bin com.cantine.Application
```

## 📋 Fonctionnalités

- **Gestion des élèves** - Ajouter, consulter, gérer les soldes
- **Gestion des repas** - Ajouter repas avec prix et quantités
- **Gestion des achats** - Traiter les achats et historique
- **Logging complet** - Traçabilité de toutes les opérations

## 🏗️ Architecture

```
com.cantine/
├── Application.java         (Point d'entrée)
├── model/
│   ├── Cantine.java        (Métier principal)
│   ├── Eleve.java          (Entité élève)
│   ├── Repas.java          (Entité repas)
│   └── Achat.java          (Historique)
└── ui/
    ├── CanteineGUI.java    (Interface principale)
    ├── FenetreEleves.java  (Gestion élèves)
    ├── FenetreRepas.java   (Gestion repas)
    └── FenetreAchat.java   (Gestion achats)
```

## 🛠️ Technologies

- **Langage:** Java 11+
- **Build:** Maven
- **GUI:** Swing (Java standard)
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
