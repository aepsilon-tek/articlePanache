package com.aepsilon.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Character extends PanacheEntity {

    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;


    public Character(){}

    public Character(Long id){this.id=id;}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
