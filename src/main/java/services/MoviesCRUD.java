/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import movie.Movies_1;
import movie.Movies_1JpaController;
import movie.exceptions.NonexistentEntityException;

/**
 *
 * @author Tatva
 */
public class MoviesCRUD {

    Movies_1 movieData = new Movies_1();

    List<Movies_1> movieList;

    @WebMethod(operationName = "listAllMovies")
    public List<Movies_1> listAllMovies() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        Movies_1JpaController movieController = new Movies_1JpaController(emf);

        movieList = movieController.findMovies_1Entities();
        return movieList;
    }

    @WebMethod(operationName = "getMovieById")
    public Movies_1 getMovieById(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        Movies_1JpaController movieController = new Movies_1JpaController(emf);

        Movies_1 movie = movieController.findMovies_1(BigDecimal.valueOf(Double.parseDouble(id)));
        return movie;
    }

    @WebMethod(operationName = "addMovie")
    public void addMovie(Movies_1 movie) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieDatabasePU");
        Movies_1JpaController movieController = new Movies_1JpaController(emf);

        try {
            movieController.create(movie);
        } catch (Exception ex) {
            Logger.getLogger(MoviesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "updateMovie")
    public void updateMovie(Movies_1 movie) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieDatabasePU");
        Movies_1JpaController movieController = new Movies_1JpaController(emf);

        try {
            movieController.edit(movie);
        } catch (Exception e) {

        }
    }

    @WebMethod(operationName = "deleteMovie")
    public void deleteMovieById(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieDatabasePU");
        Movies_1JpaController movieController = new Movies_1JpaController(emf);
        
        try {
            movieController.destroy(BigDecimal.valueOf(Double.parseDouble(id)));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MoviesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
