🔧 COMMANDES UTILES - GESTION DE CANTINE
========================================

═══════════════════════════════════════════════════════════════
🚀 DÉMARRAGE RAPIDE
═══════════════════════════════════════════════════════════════

WINDOWS (le plus simple):
  • Double-cliquer sur: build.bat
  • Ou dans PowerShell/CMD:
    cd c:\Users\Léo\Documents\Projet2BTS\GestionCantine
    .\build.bat

LINUX/MAC:
  cd ~/Documents/Projet2BTS/GestionCantine
  chmod +x build.sh
  ./build.sh

═══════════════════════════════════════════════════════════════
📦 COMPILATION MANUELLE
═══════════════════════════════════════════════════════════════

Étape 1: Créer répertoire bin
─────────────────────────────
Windows:
  mkdir bin

Linux/Mac:
  mkdir -p bin


Étape 2: Compiler avec javac
─────────────────────────────
Windows (une ligne):
  javac -d bin -sourcepath src/main/java ^
    src/main/java/com/cantine/*.java ^
    src/main/java/com/cantine/model/*.java ^
    src/main/java/com/cantine/ui/*.java

Windows (en PowerShell):
  javac -d bin -sourcepath src/main/java `
    src/main/java/com/cantine/*.java `
    src/main/java/com/cantine/model/*.java `
    src/main/java/com/cantine/ui/*.java

Linux/Mac:
  javac -d bin -sourcepath src/main/java \
    src/main/java/com/cantine/*.java \
    src/main/java/com/cantine/model/*.java \
    src/main/java/com/cantine/ui/*.java


Étape 3: Exécuter l'application
────────────────────────────────
Windows/Linux/Mac:
  java -cp bin com.cantine.Application

═══════════════════════════════════════════════════════════════
🔨 AVEC MAVEN (si Maven installé)
═══════════════════════════════════════════════════════════════

Compiler:
  mvn clean compile

Exécuter:
  mvn exec:java -Dexec.mainClass="com.cantine.Application"

Créer JAR exécutable:
  mvn clean package
  java -jar target/gestion-cantine-1.0.0.jar

Nettoyer:
  mvn clean

Voir aide:
  mvn help:describe

═══════════════════════════════════════════════════════════════
🧪 TESTER LE PROJET
═══════════════════════════════════════════════════════════════

Compiler les tests:
─────────────────
Windows:
  javac -d bin -sourcepath src/main/java ^
    src/main/java/com/cantine/model/TestCantine.java ^
    src/main/java/com/cantine/model/Cantine.java ^
    src/main/java/com/cantine/model/Eleve.java ^
    src/main/java/com/cantine/model/Repas.java ^
    src/main/java/com/cantine/model/Achat.java

Linux/Mac:
  javac -d bin -sourcepath src/main/java \
    src/main/java/com/cantine/model/TestCantine.java \
    src/main/java/com/cantine/model/Cantine.java \
    src/main/java/com/cantine/model/Eleve.java \
    src/main/java/com/cantine/model/Repas.java \
    src/main/java/com/cantine/model/Achat.java

Exécuter les tests:
──────────────────
  java -cp bin com.cantine.model.TestCantine

Résultat attendu:
  ✅ TOUS LES TESTS ONT RÉUSSI!

═══════════════════════════════════════════════════════════════
📄 FICHIERS IMPORTANTS À CONSULTER
═══════════════════════════════════════════════════════════════

Documentation générale:
  • README.md
  • GUIDE_DEMARRAGE.md
  • RESUME_FINAL.txt

Architecture et POO:
  • DOCUMENTATION_TECHNIQUE.md
  • DIAGRAMMES_UML.txt

Tests et validation:
  • GUIDE_TESTS.md
  • src/main/java/com/cantine/model/TestCantine.java

Tous les fichiers du projet:
  • FICHIERS_DU_PROJET.txt

═══════════════════════════════════════════════════════════════
🔍 VÉRIFIER L'INSTALLATION
═══════════════════════════════════════════════════════════════

Vérifier Java:
  java -version
  
Doit afficher: Java 11 ou plus récent

Vérifier Maven (optionnel):
  mvn -version

Vérifier le répertoire du projet:
  cd c:\Users\Léo\Documents\Projet2BTS\GestionCantine
  dir          (Windows)
  ls -la       (Linux/Mac)

Vérifier l'arborescence:
  tree /F      (Windows)
  tree         (Linux/Mac)

═══════════════════════════════════════════════════════════════
📊 VOIR LES LOGS
═══════════════════════════════════════════════════════════════

Afficher les logs en temps réel (Windows):
  type logs\cantine.log
  
Afficher les logs en temps réel (Linux/Mac):
  cat logs/cantine.log

Suivre les logs en direct (Linux/Mac):
  tail -f logs/cantine.log

Chercher une erreur:
  grep "WARNING" logs/cantine.log
  grep "SEVERE" logs/cantine.log

Compter les lignes:
  wc -l logs/cantine.log

═══════════════════════════════════════════════════════════════
🗂️ NAVIGATION DANS LE PROJET
═══════════════════════════════════════════════════════════════

Aller à la racine du projet:
  cd c:\Users\Léo\Documents\Projet2BTS\GestionCantine

Aller au code source:
  cd src\main\java\com\cantine

Aller aux tests:
  cd src\main\java\com\cantine\model

Voir tous les fichiers Java:
  dir /s *.java               (Windows)
  find . -name "*.java"       (Linux/Mac)

Compter les lignes de code:
  (Notepad++) menu Macro > Statistics
  cloc src/main/java/         (Linux/Mac avec cloc installé)

═══════════════════════════════════════════════════════════════
🧹 NETTOYER LE PROJET
═══════════════════════════════════════════════════════════════

Supprimer fichiers compilés:
  rmdir /s bin                (Windows)
  rm -rf bin                  (Linux/Mac)

Supprimer fichiers Maven:
  rmdir /s target             (Windows)
  rm -rf target               (Linux/Mac)

Supprimer les logs:
  del logs\*                  (Windows)
  rm logs/*                   (Linux/Mac)

Réinitialiser complètement:
  Supprimer bin/, target/, logs/
  Puis recompiler

═══════════════════════════════════════════════════════════════
🔓 GIT (si vous avez Git installé)
═══════════════════════════════════════════════════════════════

Initialiser le dépôt:
  git init

Ajouter tous les fichiers:
  git add .

Faire un commit initial:
  git commit -m "Initial commit: projet BTS gestion cantine"

Voir l'état:
  git status

Voir les modifications:
  git diff

Voir l'historique:
  git log

═══════════════════════════════════════════════════════════════
💡 RACCOURCIS VS CODE (si utilisé)
═══════════════════════════════════════════════════════════════

Ouvrir le terminal intégré:
  Ctrl + ` (backtick)

Chercher une classe:
  Ctrl + P (Quick Open)
  Taper: Application.java

Chercher du texte:
  Ctrl + F (Find)

Remplacer du texte:
  Ctrl + H (Replace)

Aller à une ligne:
  Ctrl + G

Format le code:
  Shift + Alt + F

Commentaire:
  Ctrl + / (Toggle comment)

═══════════════════════════════════════════════════════════════
⚡ TROUBLESHOOTING RAPIDE
═══════════════════════════════════════════════════════════════

Erreur: "javac not found"
→ Java n'est pas installé ou pas dans PATH
→ Installer Java 11+: https://www.oracle.com/java/technologies/javase-downloads.html

Erreur: "Cannot find symbol"
→ Fichier manquant ou mauvais chemin
→ Vérifier la structure du répertoire

Erreur: "Port already in use"
→ L'application est déjà lancée ailleurs
→ Tuer le processus Java ou attendre

Erreur: "Permission denied"
→ Fichier script n'a pas les droits d'exécution
→ chmod +x build.sh (Linux/Mac)

Erreur: "file not found: logs/cantine.log"
→ Le répertoire logs/ n'existe pas
→ mkdir logs (sera créé automatiquement au premier lancement)

═══════════════════════════════════════════════════════════════
📱 UTILISER L'APPLICATION
═══════════════════════════════════════════════════════════════

Après le lancement (java -cp bin com.cantine.Application):
  1. La fenêtre s'ouvre
  2. Cliquer sur "Gérer les élèves"
  3. Cliquer sur "Gérer les repas"
  4. Cliquer sur "Effectuer un achat"

Dans "Gérer les élèves":
  • Remplir le formulaire (tous les champs)
  • Cliquer "Ajouter"
  • La liste s'actualise automatiquement

Dans "Gérer les repas":
  • Remplir le formulaire (tous les champs)
  • Cliquer "Ajouter"
  • La liste s'actualise automatiquement

Dans "Effectuer un achat":
  • Sélectionner un élève (combobox)
  • Sélectionner un repas (combobox)
  • Cliquer "Acheter"
  • Vérifier le solde mis à jour
  • Consulter l'historique

═══════════════════════════════════════════════════════════════
📚 RESSOURCES UTILES
═══════════════════════════════════════════════════════════════

Vérifier versions requises:
  • Java: https://www.java.com/verify/
  • Maven: https://maven.apache.org/download.cgi

Documentation Java:
  • Java Docs: https://docs.oracle.com/en/java/
  • Swing: https://docs.oracle.com/javase/tutorial/uiswing/

Java Tutorials:
  • W3Schools: https://www.w3schools.com/java/
  • Oracle Docs: https://docs.oracle.com/javase/

═══════════════════════════════════════════════════════════════
🎓 POINTS IMPORTANTS POUR LA PRÉSENTATION BTS
═══════════════════════════════════════════════════════════════

À montrer:
  1. Code source bien organisé (packages)
  2. Encapsulation (getters/setters)
  3. Logging (fichier + console)
  4. Interface graphique (Swing)
  5. Tests unitaires (validation)
  6. Documentation technique
  7. Diagrammes UML

À expliquer:
  1. Pourquoi POO à 100%
  2. Comment la façade fonctionne
  3. Flux d'un achat (du clic à la base)
  4. Système de logs
  5. Couverture des tests
  6. Architecture globale

À mettre en œuvre:
  • Compiler le projet
  • Lancer l'application
  • Faire un achat
  • Consulter les logs
  • Lancer les tests

═══════════════════════════════════════════════════════════════

✅ Tout est prêt! Vous pouvez maintenant:
  1. Compiler le projet
  2. Lancer l'application
  3. Présenter votre BTS avec confiance!

═══════════════════════════════════════════════════════════════
