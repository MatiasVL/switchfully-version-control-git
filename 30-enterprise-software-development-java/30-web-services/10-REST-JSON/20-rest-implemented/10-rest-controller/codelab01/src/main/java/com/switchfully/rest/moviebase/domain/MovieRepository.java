package com.switchfully.rest.moviebase.domain;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Just a dummy - in memory - repository
 * Management Bean by Spring (will be found by component scanning)
 */
@Component
public class MovieRepository {

    private final ConcurrentHashMap<String, Movie> moviesById;

    public MovieRepository() {
        moviesById = new ConcurrentHashMap<>();
    }

    public Movie save(Movie movie) {
        moviesById.put(movie.getId(), movie);
        return movie;
    }

    /**
     * Finds the {@code Movie} object for the provided {@code id}
     *
     * @param id the id of the {@code Movie} to find
     * @return the {@code Movie} object for the specified {@code id}
     * @throws IllegalArgumentException if no {@code Movie} object was found for the specified {@code id}
     */
    public Movie getById(String id) throws IllegalArgumentException{
        var foundMovie = moviesById.get(id);
        if(foundMovie == null) {
            throw new IllegalArgumentException("No Movie could be found for id " + id);
        }
        return foundMovie;
    }

    public Collection<Movie> getAll() {
        return moviesById.values();
    }
}
