# articlePanache
Projet associé à l'article sur Panache Quarkus

# Modèle de données
```mermaid
classDiagram
    class Character{
    +String firstname
    +String lastname
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


# Build des projets depuis la racine

## Quarkus
mvn -pl sampleSpringData clean spring-boot:run
## SpringBoot
mvn -pl samplePanache clean quarkus:dev
