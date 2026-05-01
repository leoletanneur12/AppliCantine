#!/usr/bin/env pwsh

# Compile le projet
Write-Host "🔨 Compilation en cours..." -ForegroundColor Cyan
javac -encoding UTF-8 -d bin -sourcepath src/main/java @(Get-ChildItem -Recurse -Filter "*.java" src/main/java | Select-Object -ExpandProperty FullName)

if ($LASTEXITCODE -eq 0) {
    Write-Host "✓ Compilation réussie!" -ForegroundColor Green
    Write-Host "🚀 Lancement de l'application..." -ForegroundColor Cyan
    java -cp ".\bin" com.cantine.Application
} else {
    Write-Host "✗ Erreur de compilation" -ForegroundColor Red
    exit 1
}
