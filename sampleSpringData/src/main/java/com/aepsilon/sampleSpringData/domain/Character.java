package com.aepsilon.sampleSpringData.domain;

import javax.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;

    public Character(){}

    public Character(Long id){this.id=id;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
