package com.switchfully.rest.moviebase.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class MovieRepositoryTest {

    @Test
    void save_givenAMovieToSave_thenTheSavedMovieIsEqualToTheMovieToSave() {
        var movieRepository = new MovieRepository();
        var movieToSave = new Movie("Fargo", "A movie with a twist", 7200);

        Movie savedMovie = movieRepository.save(movieToSave);

        assertThat(movieToSave).isEqualTo(savedMovie);
    }

    /**
     * Our MovieRepository is actually rather difficult to test, as there's no (currently) no way to pre-populate the
     * repo's internal map with movies. Therefore, we have to use the save(...) method in the getById(...) test. Should
     * the save(...) method be broken, then is will impact this test as well (which is really not optimal...)
     */
    @Test
    void getById_givenMultipleSavedMovies_thenReturnOnlyTheMovieForTheCorrespondingId() {
        var movieRepository = new MovieRepository();
        movieRepository.save(new Movie("Flipper", "More human than dolphin", 6800));
        var movieToFind = movieRepository.save(new Movie("E.T.", "It wants to phone home", 7200));
        movieRepository.save(new Movie("Benji", "More human than dog", 6300));

        Movie actualMovie = movieRepository.getById(movieToFind.getId());

        assertThat(actualMovie).isEqualTo(movieToFind);
    }

    /**
     * Same remark as for the test-method above
     */
    @Test
    void getById_givenNoMovieForTheProvidedId_thenThrowException() {
        var movieRepository = new MovieRepository();
        movieRepository.save(new Movie("Flipper", "More human than dolphin", 6800));
        movieRepository.save(new Movie("Benji", "More human than dog", 6300));

        String unknownMovieId = UUID.randomUUID().toString();
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> movieRepository.getById(unknownMovieId))
                .withMessage("No Movie could be found for id " + unknownMovieId);
    }

    /**
     * Same remark as for the test-method above
     */
    @Test
    void getAll_givenMultipleSavedMovies_thenReturnAllTheSavedMovies() {
        var movieRepository = new MovieRepository();
        var movieToFind1 = movieRepository.save(new Movie("E.T.", "It wants to phone home", 7200));
        var movieToFind2 = movieRepository.save(new Movie("Arthur", "The true king", 7510));

        Collection<Movie> allMovies = movieRepository.getAll();

        assertThat(allMovies).containsExactlyInAnyOrder(movieToFind1, movieToFind2);
    }
}
