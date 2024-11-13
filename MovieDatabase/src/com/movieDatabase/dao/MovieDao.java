package com.movieDatabase.dao;

import java.io.*;
import java.util.ArrayList;
import com.movieDatabase.Movie;

public class MovieDao {
    private ArrayList<Movie> movies;
    private static final String FILE_NAME = "movies.ser";

    public MovieDao() {
        movies = new ArrayList<>();
        loadDatabase();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        saveDatabase();
    }

    public ArrayList<Movie> searchByTitle(String title) {
        ArrayList<Movie> foundMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                foundMovies.add(movie);
            }
        }
        return foundMovies;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in the database.");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    private void saveDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(movies);
            System.out.println("Database saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving database: " + e.getMessage());
        }
    }

    private void loadDatabase() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            movies = (ArrayList<Movie>) ois.readObject();
            System.out.println("Database loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing database found. Starting with an empty database.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading database: " + e.getMessage());
        }
    }
}