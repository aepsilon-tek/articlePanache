package com.aepsilon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie extends PanacheEntity {
    public String title;
    public String description;

    @ManyToOne
    public Genre genre;

    @OneToMany(mappedBy="movie")
    public Set<Character> characters;


    public Movie(){}
    public Movie(Long id){this.id=id;}


}
