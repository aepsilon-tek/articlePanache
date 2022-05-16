package com.aepsilon.web.rest;


import com.aepsilon.domain.Character;
import com.aepsilon.domain.Genre;
import com.aepsilon.domain.Movie;
import com.aepsilon.dto.CharacterLight;
import com.aepsilon.dto.MovieDetail;
import com.aepsilon.dto.MovieLight;
import com.aepsilon.service.MovieService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/api")
public class MovieResource {
    @Inject
    MovieService movieService;

    @GET
    @Path("/genre")
    public List<Genre> getGenre(){
        return movieService.getGenres();
    }

    @GET
    @Path("/movie")
    public List<MovieLight> getMovie(){
        return movieService.getAllMovie();
    }

    /**
     * curl -d '{"title": "movieTitle", "description": "movieDesc", "genre":{"id":"2"}}' -H "Content-Type: application/json" http://localhost:8080/api/movie
     * @param newMovie
     * @return
     */
    @POST
    @Path("/movie")
    public Response newMovie(Movie newMovie){
        Movie m =  movieService.createMovie(newMovie);
        return Response.status(Response.Status.CREATED).entity(m).build();
    }


    @GET
    @Path("/movie/{id}")
    public Response getMovieDetail(@PathParam("id") Long idMovie){
        Optional<MovieDetail>oM= movieService.getMovie(idMovie);
        if(oM.isPresent()){
            return Response.status(Response.Status.OK).entity(oM.get()).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    /**
     * curl -d '{"firstname": "prenom", "lastname": "nom"}' -H "Content-Type: application/json" http://localhost:8080/api/movie/6/character
     * @param idMovie
     * @param newCharacter
     * @return
     */
    @POST
    @Path("/movie/{id}/character")
    public Response addCharacter(@PathParam("id") Long idMovie, Character newCharacter){
        Character c =  movieService.addCharacter(idMovie,newCharacter);
        return Response.status(Response.Status.CREATED).entity(c).build();
    }

    @GET
    @Path("/movie/{id}/character")
    public List<CharacterLight> getCharacter(@PathParam("id") Long idMovie){
        return movieService.getMovieCharacter(idMovie);
    }

}
