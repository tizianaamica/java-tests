package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.model.Movie;
import com.platzi.javatests.movies.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knigth", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "Scream", 111, HORROR),
                        new Movie(4, "Home Alone", 103, COMEDY),
                        new Movie(5, "Matrix", 119, ACTION),
                        new Movie(6, "How to be single", 120, COMEDY)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        assertThat(getMovieIds(movies), is(Arrays.asList(4,6)));
    }

    @Test
    public void return_movies_by_duration() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        List<Integer> moviesIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        return moviesIds;
    }

}