package com.aepsilon.service;

import com.aepsilon.domain.Genre;
import com.aepsilon.domain.Movie;
import com.aepsilon.domain.Character;
import com.aepsilon.dto.CharacterLight;
import com.aepsilon.dto.MovieDetail;
import com.aepsilon.dto.MovieLight;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class MovieService {

    public List<Genre> getGenres(){
        return Genre.listAll();
    }

    public Movie createMovie(Movie newMovie){
            newMovie.id=null; //Force create
            newMovie.persist();
            return new Movie(newMovie.id);
    }

    public Character addCharacter(Long idMovie, Character newCharacter){
        Optional<Movie> m= Movie.findByIdOptional(idMovie);
        if(m.isPresent()){
            newCharacter.id =null; //Force create
            newCharacter.movie=m.get();
            newCharacter.persist();
            return new Character(newCharacter.id);
        }
        return null;
    }

    public List<MovieLight> getAllMovie(){
        return Movie.findAll().project(MovieLight.class).list();
    }

    public List<CharacterLight> getMovieCharacter(Long idMovie){
        return Character.find("movie.id",idMovie).project(CharacterLight.class).list();
    }


    public Optional<MovieDetail> getMovie(Long idMovie){
        //return Movie.find("from Movie m left join  m.genre g left join  m.characters c where m.id=?1",idMovie).project(MovieDetail.class).singleResultOptional();
       Optional<Movie>oM=  Movie.find("from Movie m left join fetch m.genre g left join fetch  m.characters c where m.id=?1",idMovie).singleResultOptional();
        Optional<MovieDetail> res= Optional.empty();
        if(oM.isPresent()){
            res = Optional.of(new MovieDetail(oM.get()));
        }
        return res;
    }

/*
    public void test(){
        List<Movie> movies = Movie.listAll();

        Long nbMovie  = Movie.count();

        Movie newMovie = new Movie();
        newMovie.title="titre";
        newMovie.description="desc film";
        newMovie.persist();

        newMovie.delete();

    }

 */

}

