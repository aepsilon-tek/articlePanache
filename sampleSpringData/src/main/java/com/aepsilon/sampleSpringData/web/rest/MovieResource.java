package com.aepsilon.sampleSpringData.web.rest;

import com.aepsilon.sampleSpringData.domain.Character;
import com.aepsilon.sampleSpringData.domain.Genre;
import com.aepsilon.sampleSpringData.domain.Movie;
import com.aepsilon.sampleSpringData.dto.CharacterLight;
import com.aepsilon.sampleSpringData.dto.MovieDetail;
import com.aepsilon.sampleSpringData.dto.MovieLight;
import com.aepsilon.sampleSpringData.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieResource {

    @Autowired
    MovieService movieService;

    @GetMapping("/genre")
    public List<Genre> getGenre(){
        return movieService.getGenres();
    }

    @GetMapping("/movie")
    public List<MovieLight> getMovie(){
        return movieService.getAllMovie();
    }

    /**
     * curl -d '{"title": "movieTitle", "description": "movieDesc", "genre":{"id":"2"}}' -H "Content-Type: application/json" http://localhost:8080/api/movie
     * @param newMovie
     * @return
     */
    @PostMapping("/movie")
    public ResponseEntity<Movie> newMovie(@RequestBody Movie newMovie){
        Movie m =  movieService.createMovie(newMovie);
        return ResponseEntity.created(null).body(m);
    }


    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDetail> getMovieDetail(@PathVariable("id") Long idMovie){
        Optional<MovieDetail> oM= movieService.getMovie(idMovie);
        if(oM.isPresent()){
            return ResponseEntity.ok().body(oM.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * curl -d '{"firstname": "prenom", "lastname": "nom"}' -H "Content-Type: application/json" http://localhost:8080/api/movie/6/character
     * @param idMovie
     * @param newCharacters
     * @return
     */
    @PostMapping("/movie/{id}/character")
    public ResponseEntity<Character> addCharacter(@PathVariable("id") Long idMovie, @RequestBody Character newCharacters){
        Characters c =  movieService.addCharacter(idMovie, newCharacters);
        return ResponseEntity.created(null).body(c);
    }

    @GetMapping("/movie/{id}/character")
    public List<CharacterLight> getCharacter(@PathVariable("id") Long idMovie){
        return movieService.getMovieCharacter(idMovie);
    }


}
