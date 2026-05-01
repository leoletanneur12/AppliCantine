@echo off
REM Script de compilation et exécution du projet Gestion Cantine

echo ================================
echo Gestion de Cantine - Compilation
echo ================================

REM Créer le répertoire bin s'il n'existe pas
if not exist bin mkdir bin

REM Compiler tous les fichiers Java
echo Compilation en cours...
javac -encoding UTF-8 -d bin -sourcepath src/main/java src/main/java/com/cantine/*.java src/main/java/com/cantine/model/*.java src/main/java/com/cantine/ui/*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation réussie!
    echo.
    echo Lancement de l'application...
    echo.
    REM Exécuter l'application
    java -cp bin com.cantine.Application
) else (
    echo Erreur lors de la compilation!
    pause
)
