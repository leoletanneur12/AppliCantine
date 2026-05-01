@echo off
cd /d "%~dp0"
javac -encoding UTF-8 -d bin -sourcepath src/main/java src/main/java/com/cantine/*.java src/main/java/com/cantine/model/*.java src/main/java/com/cantine/ui/*.java
if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilation reussie!
    echo.
    echo Lancement de l'application...
    java -cp bin com.cantine.Application
) else (
    echo Erreur de compilation
    pause
)
