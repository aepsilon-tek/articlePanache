# articlePanache
Projet associé à l'article sur Panache Quarkus

# Modèle de données
```mermaid
classDiagram
    class Character{
    +String firstname
    +String laststname
    }
    
    class Genre{
    +String name
    }
    
    class Movie{
       +String title
       +String description
    }
    
    Movie "1" ..> "1..*" Character
    Genre "1" --> "1..*" Movie
    
```
