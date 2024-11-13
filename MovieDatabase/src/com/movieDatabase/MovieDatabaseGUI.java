package com.movieDatabase;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.movieDatabase.dao.MovieDao;

public class MovieDatabaseGUI {
    private MovieDao movieDao;

    public MovieDatabaseGUI() {
        movieDao = new MovieDao();
        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame("Movie Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Movie Database System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 5, 5));

        // Add Movie Button
        JButton addMovieButton = new JButton("Add Movie");
        addMovieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMovieDialog();
            }
        });
        buttonPanel.add(addMovieButton);

        // Search Movie Button
        JButton searchMovieButton = new JButton("Search by Title");
        searchMovieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchMovieDialog();
            }
        });
        buttonPanel.add(searchMovieButton);

        // Display All Movies Button
        JButton displayMoviesButton = new JButton("Display All Movies");
        displayMoviesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllMoviesDialog();
            }
        });
        buttonPanel.add(displayMoviesButton);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> frame.dispose());
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Dialog for Adding a Movie
    private void addMovieDialog() {
        JTextField titleField = new JTextField(10);
        JTextField directorField = new JTextField(10);
        JTextField yearField = new JTextField(5);
        JTextField genreField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(Box.createHorizontalStrut(15)); // Spacer
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(Box.createHorizontalStrut(15)); // Spacer
        panel.add(new JLabel("Year:"));
        panel.add(yearField);
        panel.add(Box.createHorizontalStrut(15)); // Spacer
        panel.add(new JLabel("Genre:"));
        panel.add(genreField);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Add Movie", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            String director = directorField.getText();
            int year = Integer.parseInt(yearField.getText());
            String genre = genreField.getText();
            Movie newMovie = new Movie(title, director, year, genre);
            movieDao.addMovie(newMovie);
            JOptionPane.showMessageDialog(null, "Movie added successfully!");
        }
    }

    // Dialog for Searching a Movie
    private void searchMovieDialog() {
        String title = JOptionPane.showInputDialog("Enter movie title to search:");
        if (title != null && !title.trim().isEmpty()) {
            ArrayList<Movie> results = movieDao.searchByTitle(title);
            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Movie not found.");
            } else {
                StringBuilder resultText = new StringBuilder("Search Results:\n");
                for (Movie movie : results) {
                    resultText.append(movie.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, resultText.toString());
            }
        }
    }

    // Dialog for Displaying All Movies
    private void displayAllMoviesDialog() {
        ArrayList<Movie> movies = movieDao.getMovies();
        if (movies.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No movies in the database.");
        } else {
            StringBuilder moviesList = new StringBuilder("Movies in Database:\n");
            for (Movie movie : movies) {
                moviesList.append(movie.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, moviesList.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovieDatabaseGUI::new);
    }
}