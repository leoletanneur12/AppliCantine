GUIDE DÉMARRAGE RAPIDE
======================

## 1️⃣ DÉMARRER L'APPLICATION

### Option A: Avec le script batch (Windows)
```
Double-cliquer sur build.bat
```

### Option B: Avec le script shell (Linux/Mac)
```bash
chmod +x build.sh
./build.sh
```

### Option C: Avec Maven
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.cantine.Application"
```

### Option D: Compilation manuelle
```bash
# Créer répertoire bin
mkdir bin

# Compiler
javac -d bin -sourcepath src/main/java ^
  src/main/java/com/cantine/*.java ^
  src/main/java/com/cantine/model/*.java ^
  src/main/java/com/cantine/ui/*.java

# Exécuter
java -cp bin com.cantine.Application
```

---

## 2️⃣ STRUCTURE DU PROJET

```
GestionCantine/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── cantine/
│       │           ├── Application.java          ⭐ Point d'entrée
│       │           │
│       │           ├── model/                    📦 Classes métier
│       │           │   ├── Cantine.java         (Orchestration)
│       │           │   ├── Eleve.java           (Données élève)
│       │           │   ├── Repas.java           (Données repas)
│       │           │   └── Achat.java           (Historique)
│       │           │
│       │           └── ui/                       🎨 Interface GUI
│       │               ├── CanteineGUI.java     (Fenêtre principale)
│       │               ├── FenetreEleves.java   (Gestion élèves)
│       │               ├── FenetreRepas.java    (Gestion repas)
│       │               └── FenetreAchat.java    (Gestion achats)
│       │
│       └── resources/
│           └── (Ressources si nécessaire)
│
├── logs/                                         📝 Fichiers de log
│   └── cantine.log
│
├── bin/                                          📦 Fichiers compilés
│   └── (Généré après compilation)
│
├── target/                                       📦 Sortie Maven
│   └── (Généré après maven build)
│
├── pom.xml                                       ⚙️ Configuration Maven
├── build.bat                                     🔧 Script Windows
├── build.sh                                      🔧 Script Linux/Mac
├── .gitignore                                    📋 Git ignore
├── README.md                                     📖 Documentation
└── DOCUMENTATION_TECHNIQUE.md                    📖 Doc technique

```

---

## 3️⃣ FONCTIONNALITÉS PRINCIPALES

### Fenêtre Principale
- 3 boutons pour les 3 fonctionnalités principales
- Interface claire et intuitive
- Design professionnel

### Gérer les Élèves
✅ Ajouter un élève (nom, prénom, matricule, solde)
✅ Voir la liste des élèves
✅ Consulter soldes en temps réel

### Gérer les Repas
✅ Ajouter un repas (nom, prix, quantité)
✅ Voir la liste des repas
✅ Consulter stocks disponibles

### Effectuer un Achat
✅ Sélectionner un élève et un repas
✅ Débiter automatiquement le solde
✅ Réduire la quantité
✅ Voir l'historique complet

---

## 4️⃣ DONNÉES DE TEST

L'application démarre avec données pré-chargées:

**Repas:**
- Poulet rôti (5.50€, 20 en stock)
- Steak frites (6.00€, 15 en stock)
- Salade composée (4.50€, 25 en stock)
- Pâtes carbonara (5.00€, 18 en stock)

**Élèves:**
- Jean Dupont (ID: E001, solde: 20.00€)
- Marie Martin (ID: E002, solde: 15.50€)
- Pierre Bernard (ID: E003, solde: 25.00€)

---

## 5️⃣ LOGS

Les logs sont générés dans `logs/cantine.log` et en console:

```
[Timestamp] [LEVEL]: Message
```

**Exemples:**
```
[2026-04-30 10:15:23] INFO: === Démarrage de l'application de gestion de cantine ===
[2026-04-30 10:15:23] INFO: Élève ajouté: Jean Dupont
[2026-04-30 10:15:45] INFO: Achat enregistré: Jean Dupont a acheté Poulet rôti
[2026-04-30 10:16:12] WARNING: Achat échoué pour Marie Martin - Solde insuffisant
```

---

## 6️⃣ POINTS CLÉS DE PROGRAMMATION OBJET

### ✅ Classe Model (Métier)
```java
// Encapsulation: Attributs privés + getters/setters
// Méthodes spécialisées: debiter(), crediter(), diminuerQuantite()
// toString() surchargé pour affichage personnalisé
```

### ✅ Classe Cantine (Façade)
```java
// Gère les collections d'élèves et repas
// Effectue les transactions (achats)
// Orchestre les interactions entre objets
```

### ✅ Classes UI (Swing)
```java
// Séparation Model/View stricte
// Listeners sur boutons
// Mise à jour automatique des affichages
```

### ✅ Logging
```java
// Chaque action importante est loggée
// Fichier + console
// Niveaux: INFO, WARNING, SEVERE
```

---

## 7️⃣ MODIFICATIONS RECOMMANDÉES POUR PRÉSENTATION BTS

### Pour améliorer le projet:

1. **Ajouter une classe Transactions** pour plus de complexité POO
2. **Ajouter une classe Horaire** pour limiter les achats par créneau
3. **Système de réductions** pour élèves boursiers
4. **Rapports financiers** (total journalier, mensuel)
5. **Persistance Base de Données** (MySQL/SQLite)

### Pour la présentation orale:
- Expliquer pourquoi chaque classe existe
- Montrer comment le polymorphisme est utilisé
- Démontrer le système de logs
- Parler de l'architecture MVC

---

## 8️⃣ DÉPANNAGE

**Problème: "Aucun élève enregistré" au démarrage**
→ Vérifier que la méthode ajouterDonneesTest() est appelée

**Problème: Les logs ne s'enregistrent pas**
→ Vérifier que le répertoire `logs/` existe
→ Vérifier les permissions d'écriture

**Problème: Interface mal affichée**
→ Vérifier la version de Java (11+)
→ Vérifier les polices disponibles

**Problème: Compilation échoue**
→ Vérifier Java 11+ installé: `java -version`
→ Vérifier que tous les fichiers sont dans le bon répertoire

---

## 9️⃣ RESSOURCES DOCUMENTATION

- README.md: Vue d'ensemble générale
- DOCUMENTATION_TECHNIQUE.md: Architecture POO détaillée
- Code source: Commentaires JavaDoc complets

---

**Bon courage pour votre présentation BTS! 🚀**
