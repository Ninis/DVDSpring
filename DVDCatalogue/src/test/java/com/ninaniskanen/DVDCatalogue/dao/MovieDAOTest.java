package com.ninaniskanen.DVDCatalogue.dao;

import com.ninaniskanen.DVDCatalogue.exception.DAOException;
import com.ninaniskanen.DVDCatalogue.model.Movie;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class MovieDAOTest {

    @Test
    public void shouldReturnListofMovies() throws DAOException{
        MovieDAO movieDAO = new MovieDAO();

        List<Movie> movieList = movieDAO.getAll();

        assertFalse(movieList.isEmpty());
    }
}
