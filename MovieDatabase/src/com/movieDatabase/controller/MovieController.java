package com.movieDatabase.controller;

import java.util.Scanner;

import com.movieDatabase.Movie;
import com.movieDatabase.dao.MovieDao;

public class MovieController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDao movieDao = new MovieDao();

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Movie\n2. Search by Title\n3. Display All Movies\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Movie director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    Movie newMovie = new Movie(title, director, year, genre);
                    movieDao.addMovie(newMovie);
                    System.out.println("Movie added successfully.");
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    movieDao.searchByTitle(searchTitle);
                    break;
                case 3:
                    movieDao.displayAllMovies();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        System.out.println("Exiting program.");
        scanner.close();
    }

}