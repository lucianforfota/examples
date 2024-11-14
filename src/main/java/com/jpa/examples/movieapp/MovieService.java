package com.jpa.examples.movieapp;

import jakarta.transaction.Transactional;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private CharacterRepository characterRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository , CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository   = characterRepository;
    }

    @Transactional
    public Character addCharacterToMovie(Character character, Long movieId) throws Exception{
        Movie movie = movieRepository.findById(movieId).orElseThrow(()->new Exception("movie not found"));
        character.getMovies().add(movie);
        movie.getCharacters().add(character);
        return characterRepository.save(character);
    }

    public List<Movie> findByFranchise (Long franchiseId){
        return movieRepository.findAllByFranchise_Id(franchiseId);
    }

}
