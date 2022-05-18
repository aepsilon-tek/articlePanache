package com.aepsilon.dto;

import com.aepsilon.domain.Character;
import com.aepsilon.domain.Genre;
import com.aepsilon.domain.Movie;
import io.quarkus.hibernate.orm.panache.common.ProjectedFieldName;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RegisterForReflection
public class MovieDetail {
    private Long id;
    private String title;
    private String description;
    private Genre genre;
    private Set<CharacterLight> characters;


   //public MovieDetail(@ProjectedFieldName("m.id")Long id, String title, String description,@ProjectedFieldName("g") Genre genre,@ProjectedFieldName("c") Set<Character>characters){
   //public MovieDetail(@ProjectedFieldName("m.id")Long id, String title, String description,@ProjectedFieldName("g.id") Long genreId){
   public MovieDetail( Movie m){
       this.id=m.id;
       this.title=m.title;
       this.description=m.description;
       this.genre = m.genre;

       System.out.println(" SIZE >"+m.characters.size());

       if(m.characters!= null){
           characters = new HashSet<>();
           for(Character currentC: m.characters){
               characters.add(new CharacterLight(currentC.id,currentC.firstname ,currentC.lastname));
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
