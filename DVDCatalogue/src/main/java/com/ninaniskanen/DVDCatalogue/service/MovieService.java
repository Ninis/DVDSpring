package com.ninaniskanen.DVDCatalogue.service;

import com.ninaniskanen.DVDCatalogue.dao.MovieDAO;
import com.ninaniskanen.DVDCatalogue.exception.DAOException;
import com.ninaniskanen.DVDCatalogue.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    @Autowired
    MovieDAO movieDAO;

    public List<Movie> getAll() throws DAOException {
        return movieDAO.getAll();
    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

}
