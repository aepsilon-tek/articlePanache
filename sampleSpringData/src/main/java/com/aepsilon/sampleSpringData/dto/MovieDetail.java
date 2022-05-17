package com.aepsilon.sampleSpringData.dto;

import com.aepsilon.sampleSpringData.domain.Character;
import com.aepsilon.sampleSpringData.domain.Genre;
import com.aepsilon.sampleSpringData.domain.Movie;

import java.util.HashSet;
import java.util.Set;

public class MovieDetail {
    private Long id;
    private String title;
    private String description;
    private Genre genre;
    private Set<CharacterLight> characters;


   public MovieDetail( Movie m){
       this.id=m.getId();
       this.title=m.getTitle();
       this.description=m.getDescription();
       this.genre = m.getGenre();

       System.out.println(" SIZE >"+m.getCharacters().size());

       if(m.getCharacters()!= null){
           characters = new HashSet<>();
           for(Character currentC: m.getCharacters()){
               characters.add(new CharacterLight(currentC.getId(),currentC.getFirstname(),currentC.getLastname()));
           }
       }

   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<CharacterLight> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<CharacterLight> characters) {
        this.characters = characters;
    }
}
