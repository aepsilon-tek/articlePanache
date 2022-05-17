package com.aepsilon.sampleSpringData.repository;

import com.aepsilon.sampleSpringData.domain.Movie;
import com.aepsilon.sampleSpringData.dto.MovieDetail;
import com.aepsilon.sampleSpringData.dto.MovieLight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("select new com.aepsilon.sampleSpringData.dto.MovieLight(m.id,m.title,m.description) from Movie m")
    List<MovieLight> getAllMovie();


    @Query("select m from Movie m left join fetch m.genre g left join fetch  m.characters c where m.id= :idMovie")
    Optional<Movie> getMovieDetail(@Param("idMovie")Long idMovie);
}
