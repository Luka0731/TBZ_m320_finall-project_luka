# Design Patterns Dokumentation

## 1. Einleitung
In diesem Projekt werden mehrere **GoF (Gang of Four)** Design Patterns angewendet, um eine saubere, wartbare und erweiterbare Backend-Architektur für die Online-Buchplattform zu schaffen.

Der Begriff *Gang of Four* bezieht sich auf die vier Autoren des Buchs  
*"Design Patterns: Elements of Reusable Object-Oriented Software" (1994)*  
Dieses Buch definiert 23 klassische Entwurfsmuster, die in drei Gruppen eingeteilt sind: **Erzeugungsmuster**, **Strukturmuster** und **Verhaltensmuster**.

Mehr dazu zu lesen gibt es auf dieser Webseit: https://refactoring.guru/design-patterns

In diesem Projekt werden zwei davon verwendet:

1. **Strategy Pattern**  
2. **Template Method Pattern**

---

## 2. Strategy Pattern

### 2.1 Motivation in diesem Projekt
Das System soll verschiedene Möglichkeiten bieten, Bücher anzuzeigen:
- Neueste Bücher zuerst  
- Meistgelikte Bücher  
- Nach Tag gefilterte Bücher  

Ohne Strategy würde der Service viele `if` oder `switch`-Abfragen enthalten. Mit Strategy kann die passende Implementierung zur Laufzeit gewählt werden.

### 2.2 Code Referenzen
- **Interface:** `BookListingStrategy.java`  
- **Implementierungen:** `NewestFirstStrategy.java`, `MostLikedStrategy.java`, `ByTagStrategy.java`  
- **Verwendung:** `BookListingService.java`

---

## 3. Template Method Pattern

### 3.1 Motivation in diesem Projekt
Das Projekt verwendet eine generische Service-Schicht. Diese Basisklasse definiert Standard-CRUD-Operationen (save, update, deleteById, findAll) und wird von konkreten Services erweitert, die nur spezifische Logik hinzufügen.

### 3.2 Code Referenzen
- **Basisklasse:** `AbstractServiceImpl.java`
- **Spezifische Services:** `BookServiceImpl.java`, `UserServiceImpl.java`, usw.