package com.aepsilon.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Character extends PanacheEntity {

    public String firstname;
    public String lastname;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    public Movie movie;


    public Character(){}

    public Character(Long id){this.id=id;}


}
