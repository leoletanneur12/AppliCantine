#!/bin/bash
# Script de compilation et exécution du projet Gestion Cantine

echo "================================"
echo "Gestion de Cantine - Compilation"
echo "================================"

# Créer le répertoire bin s'il n'existe pas
mkdir -p bin

# Compiler tous les fichiers Java
echo "Compilation en cours..."
javac -d bin -sourcepath src/main/java \
    src/main/java/com/cantine/*.java \
    src/main/java/com/cantine/model/*.java \
    src/main/java/com/cantine/ui/*.java

if [ $? -eq 0 ]; then
    echo "Compilation réussie!"
    echo ""
    echo "Lancement de l'application..."
    echo ""
    # Exécuter l'application
    java -cp bin com.cantine.Application
else
    echo "Erreur lors de la compilation!"
    exit 1
fi
