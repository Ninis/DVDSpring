package com.ninaniskanen.DVDCatalogue.controller;

import com.ninaniskanen.DVDCatalogue.exception.DAOException;
import com.ninaniskanen.DVDCatalogue.model.Movie;
import com.ninaniskanen.DVDCatalogue.service.MovieService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @Mock private MovieService movieService;

    @Test
    public void shouldDisplayListofMovies() throws DAOException{
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie(1, "Batman Begins"));
        movieList.add(new Movie(2, "Midnight Run"));
        movieList.add(new Movie(3, "Casablanca"));
        movieList.add(new Movie(4, "Stardust"));

        HomeController homeController = new HomeController(movieService);

        when(movieService.getAll()).thenReturn(movieList);

        HashMap<String, Object> model = new HashMap<String, Object>();

        ModelAndView mav = homeController.home(model);

        String viewName = mav.getViewName();

        Map<String, Object> newModel = mav.getModel();
        Map<String, Object> internalModel = (Map)newModel.get("model");

        assertEquals("list", viewName);
        assertNotNull(internalModel.get("movies"));
        assertSame(movieList, internalModel.get("movies"));

        verify(movieService).getAll();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
