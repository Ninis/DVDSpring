package com.ninaniskanen.DVDCatalogue.controller;

import com.ninaniskanen.DVDCatalogue.exception.DAOException;
import com.ninaniskanen.DVDCatalogue.model.Movie;
import com.ninaniskanen.DVDCatalogue.service.MovieService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * HomeController for DVDCatalogue Web Application.
 *
 * @author Nina Niskanen
 */

@Controller
public class HomeController {
    @Autowired
    private MovieService movieService;

    public HomeController() {

    }

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping({"/"})
    public ModelAndView home(Map<String, Object> model) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");

        List<Movie> movieList = null;

        try{
             movieList = movieService.getAll();

        } catch (DAOException e){
            model.put("error", "Unable to get data. Please try again later.");
        }


        model.put("movies", movieList);

        mav.addObject("model", model);
        return mav;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieService getMovieService() {
        return this.movieService;
    }
}
