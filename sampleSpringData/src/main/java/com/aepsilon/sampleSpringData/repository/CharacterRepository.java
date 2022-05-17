package com.aepsilon.sampleSpringData.repository;

import com.aepsilon.sampleSpringData.domain.Character;
import com.aepsilon.sampleSpringData.domain.Movie;
import com.aepsilon.sampleSpringData.dto.CharacterLight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {

    @Query("select new com.aepsilon.sampleSpringData.dto.CharacterLight(c.id    ,c.firstname,c.lastname) from Character c where c.movie.id=:movieId")
    List<CharacterLight> findByMovieId(@Param("movieId")Long movieId);

}
