DOCUMENTATION TECHNIQUE - Gestion de Cantine
==============================================

## Architecture POO

### Principes SOLID Appliqués

#### 1. ENCAPSULATION (Classe Eleve)
```java
// Attributs privés avec accès contrôlé
private String nom;
private String prenom;
private String matricule;
private double solde;

// Getters et setters publics
public double getSolde() { return solde; }
public void setSolde(double solde) { this.solde = solde; }
```

#### 2. RESPONSABILITÉ UNIQUE
- **Eleve.java**: Gère uniquement les données et logique de l'élève
- **Repas.java**: Gère uniquement les données et logique du repas
- **Achat.java**: Gère uniquement l'enregistrement d'un achat
- **Cantine.java**: Orchestration et coordination entre les objets

#### 3. POLYMORPHISME (toString override)
```java
// Chaque classe surcharge toString pour ses propres besoins
@Override
public String toString() {
    return prenom + " " + nom + " (ID: " + matricule + ") - Solde: " + solde + "€";
}
```

#### 4. ABSTRACTION
Les détails de gestion sont cachés:
- La classe Eleve expose debiter() et crediter() sans détails internes
- La classe Cantine expose enregistrerAchat() qui gère tout le flux

---

## Diagramme des Classes

```
┌─────────────────┐
│     Cantine     │ ◄── Classe de coordination
└─────────────────┘
       │ manages
       ├──► Eleve
       ├──► Repas
       └──► Achat

┌─────────────────┐
│     Eleve       │ ◄── Classe métier
├─────────────────┤
│ - nom: String   │
│ - prenom: String│
│ - matricule: Str│
│ - solde: double │
├─────────────────┤
│ + debiter()     │
│ + crediter()    │
└─────────────────┘

┌─────────────────┐
│     Repas       │ ◄── Classe métier
├─────────────────┤
│ - nom: String   │
│ - prix: double  │
│ - quantité: int │
├─────────────────┤
│ + diminuerQté() │
└─────────────────┘

┌─────────────────┐
│     Achat       │ ◄── Classe métier
├─────────────────┤
│ - eleve: Eleve  │
│ - repas: Repas  │
│ - date: LocalDT │
└─────────────────┘
```

---

## Patterns de Conception Utilisés

### 1. FAÇADE (Cantine.java)
La classe Cantine agit comme façade, simplifiant l'interaction:
```java
// Utilisant seulement l'interface simple
cantine.enregistrerAchat(eleve, repas);
```

### 2. MVC - Model-View-Controller
- **Model**: Packages `com.cantine.model` (classes métier)
- **View**: Packages `com.cantine.ui` (interfaces graphiques)
- **Controller**: Application.java (point d'entrée)

### 3. REPOSITORY (implicite)
La classe Cantine maintient des collections:
```java
private List<Eleve> eleves;      // Repository d'élèves
private List<Repas> repas;       // Repository de repas
private List<Achat> historique;  // Repository d'achats
```

---

## Flux d'Utilisation Principaux

### Flux 1: Ajouter un élève
```
FenetreEleves.btnAjouter.click()
    ↓
new Eleve(nom, prenom, matricule, solde)
    ↓
cantine.ajouterEleve(eleve)
    ↓
logger.log("Élève ajouté: ...")
    ↓
updateDisplay()
```

### Flux 2: Enregistrer un achat
```
FenetreAchat.btnAcheter.click()
    ↓
cantine.enregistrerAchat(eleve, repas)
    ↓
repas.diminuerQuantite(1)    // Check quantité
    ↓
eleve.debiter(prix)          // Check solde
    ↓
new Achat(eleve, repas)      // Créer trace
    ↓
historique.add(achat)        // Enregistrer
    ↓
logger.log("Achat enregistré")
```

---

## Système de Logging

### Configuration
```java
// FileHandler: Logs dans fichier
FileHandler fileHandler = new FileHandler("logs/cantine.log", true);

// ConsoleHandler: Logs en console
ConsoleHandler consoleHandler = new ConsoleHandler();

// Format: [TIMESTAMP] [LEVEL]: MESSAGE
```

### Points de Log Critiques
1. **INFO**: Opérations réussies
   - Ajout d'élève/repas
   - Achat enregistré
   - Initialisation

2. **WARNING**: Opérations échouées
   - Achat échoué (solde insuffisant)
   - Élève non trouvé
   - Champs vides

3. **SEVERE**: Erreurs critiques
   - Erreur de fichier log

---

## Guide Développeur

### Ajouter une nouvelle fonctionnalité

**Exemple: Système de réduction**

1. Ajouter dans **Repas.java**:
```java
private double reduction = 0;
public void appliquerReduction(double pourcentage) {
    this.reduction = pourcentage;
    logger.log(Level.INFO, "Réduction appliquée: " + pourcentage + "%");
}
public double getPrixFinal() {
    return prix * (1 - reduction / 100);
}
```

2. Ajouter dans **Cantine.java**:
```java
public void appliquerReductionRepas(String nomRepas, double pourcentage) {
    for (Repas r : repas) {
        if (r.getNom().equals(nomRepas)) {
            r.appliquerReduction(pourcentage);
            return;
        }
    }
}
```

3. Ajouter interface dans **FenetreRepas.java**:
```java
JButton btnReduction = new JButton("Appliquer réduction");
btnReduction.addActionListener(e -> {
    double reduction = Double.parseDouble(JOptionPane.showInputDialog("Pourcentage:"));
    cantine.appliquerReductionRepas(repasSelectionne.getNom(), reduction);
});
```

---

## Tests Unitaires Possibles

```java
public class TestCantine {
    @Test
    public void testAjoutEleve() {
        Cantine c = new Cantine("Test");
        Eleve e = new Eleve("Dupont", "Jean", "E001", 20.0);
        c.ajouterEleve(e);
        assertTrue(c.getEleves().size() == 1);
    }
    
    @Test
    public void testAchatReussi() {
        // Créer cantine avec données
        // Effectuer achat
        // Vérifier solde réduit et quantité réduite
    }
    
    @Test
    public void testAchatEchouéSoldInstant() {
        // Elève avec solde trop bas
        // Vérifier que l'achat échoue
    }
}
```

---

**Version**: 1.0  
**Dernière mise à jour**: 2026-04-30
