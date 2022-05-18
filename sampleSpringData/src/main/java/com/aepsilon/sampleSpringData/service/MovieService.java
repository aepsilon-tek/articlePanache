package com.aepsilon.sampleSpringData.service;

import com.aepsilon.sampleSpringData.domain.Character;
import com.aepsilon.sampleSpringData.domain.Genre;
import com.aepsilon.sampleSpringData.domain.Movie;
import com.aepsilon.sampleSpringData.dto.CharacterLight;
import com.aepsilon.sampleSpringData.dto.MovieDetail;
import com.aepsilon.sampleSpringData.dto.MovieLight;
import com.aepsilon.sampleSpringData.repository.CharacterRepository;
import com.aepsilon.sampleSpringData.repository.GenreRepository;
import com.aepsilon.sampleSpringData.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class MovieService {
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CharacterRepository characterRepository;


    public List<Genre>  getGenres(){
        return genreRepository.findAll();
    }


    public Movie createMovie(Movie newMovie){
        Movie m= movieRepository.save(newMovie);
        return new Movie(m.getId());
    }

    public Character addCharacter(Long idMovie, Character newCharacter){
        Optional<Movie> m= movieRepository.findById(idMovie);
        if(m.isPresent()){
            newCharacter.setMovie(m.get());
            Character c= characterRepository.save(newCharacter);
            return new Character(c.getId());
        }
        return null;
    }

    public List<MovieLight> getAllMovie(){
        return movieRepository.getAllMovie();
    }

    public List<CharacterLight> getMovieCharacter(Long idMovie){
        return characterRepository.findByMovieId(idMovie);
    }


    public Optional<MovieDetail> getMovie(Long idMovie){
        Optional<Movie>oM= movieRepository.getMovieDetail(idMovie);
        Optional<MovieDetail> res= Optional.empty();
        if(oM.isPresent()){
            res = Optional.of(new MovieDetail(oM.get()));
        }
        return res;
    }
}
