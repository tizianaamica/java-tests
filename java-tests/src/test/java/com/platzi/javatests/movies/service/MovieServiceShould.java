package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import com.platzi.javatests.movies.repository.MovieRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MovieServiceShould {

    @Test
    public void return_movies_by_genre() {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knigth", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "Scream", 111, HORROR),
                        new Movie(4, "Home Alone", 103, COMEDY),
                        new Movie(5, "Matrix", 136, ACTION),
                        new Movie(6, "How to be single", 120, COMEDY)
                )
        );

        MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        assertThat(moviesIds, is(Arrays.asList(4,6)));

    }
}