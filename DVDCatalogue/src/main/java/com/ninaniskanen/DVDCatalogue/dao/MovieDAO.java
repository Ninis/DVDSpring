package com.ninaniskanen.DVDCatalogue.dao;

import au.com.bytecode.opencsv.CSVReader;
import com.ninaniskanen.DVDCatalogue.exception.DAOException;
import com.ninaniskanen.DVDCatalogue.model.Movie;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This light DAO reads a CSV file for a list of all the movies.
 *
 * @author Nina Niskanen
 */

public class MovieDAO {


    public List<Movie> getAll() throws DAOException{

        List<Movie> movies = new ArrayList<Movie>();

        try {
            CSVReader reader = new CSVReader(new InputStreamReader(getClass().getResourceAsStream("/data.csv")));
            String [] nextLine;
            Movie movie;
            while ((nextLine = reader.readNext()) != null) {
                movie = new Movie();
                movie.setId(Integer.parseInt(nextLine[0]));
                movie.setName(nextLine[1]);
                movie.setTranslatedName(nextLine[2]);
                movies.add(movie);
            }
            reader.close();
        } catch (Exception e){
            throw new DAOException(e.getStackTrace());
        }

        return movies;
    }
}
