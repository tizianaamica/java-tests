package com.platzi.javatests.movies.repository;

import com.platzi.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static com.platzi.javatests.movies.model.Genre.ACTION;
import static com.platzi.javatests.movies.model.Genre.THRILLER;
import static org.hamcrest.CoreMatchers.is;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {
        Collection<Movie> movieCollection = movieRepositoryJdbc.findAll();

        Assert.assertThat(movieCollection, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION)
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryJdbc.findById(2);
        Assert.assertThat(movie, is(new Movie(2, "Memento", 113, THRILLER)));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Super 8", 112, THRILLER);
        movieRepositoryJdbc.saveOrUpdate(movie);
        Movie movieFromDB = movieRepositoryJdbc.findById(4);
        Assert.assertThat(movieFromDB, is(new Movie(4,"Super 8", 112, THRILLER)));
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}