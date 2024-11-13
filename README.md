# Hex_Softwares_Project_MovieDatabase

This Movie Database System is a simple Java-based application that allows users to manage a collection of movies. The system supports basic functionalities like adding new movies, searching for movies by title, and displaying a list of all movies stored in the database. The application uses a graphical user interface (GUI) built with Java Swing, and the data is serialized to a file for persistent storage.

Key Features:
Add Movie:

Users can add a new movie to the database by entering details such as the movie's title, director, year of release, and genre.
The movie details are stored in a Movie object and then serialized to a file for persistent storage.
Search by Title:

Users can search for a movie by its title.
The system performs a case-insensitive search and displays all matching results.
Display All Movies:

The system can display all movies currently stored in the database.
Movies are shown with details such as title, director, year, and genre.
Persistent Data Storage:

The system uses file serialization to save and load the movie list. The movie data is saved in a .ser file (movies.ser), which allows the database to persist even when the application is closed and reopened.
Graphical User Interface (GUI):

The system is equipped with a user-friendly GUI that provides interactive buttons for the available actions (add, search, display, and exit).
Dialog boxes are used for user inputs, such as entering movie details and search queries.
Results of actions (e.g., added movie, search results, list of all movies) are displayed using message dialogs.
Components of the System:
Movie Class:

A simple model class (Movie) that holds the movie's title, director, year, and genre.
The class implements Serializable to allow movie objects to be written to and read from a file.
MovieDao Class:

The data access object (MovieDao) handles the movie database's CRUD operations (add, search, retrieve).
It uses ObjectOutputStream and ObjectInputStream to serialize and deserialize the list of movies to/from a file.
MovieDatabaseGUI Class:

The GUI class built using Java Swing provides a window with buttons for interacting with the system.
Actions like adding a movie, searching by title, and displaying all movies are triggered through button clicks, which then open corresponding dialogs.
Workflow:
Adding a Movie:

When the user selects the "Add Movie" button, a dialog appears where they can enter the movie's title, director, year, and genre. After submitting the form, the movie is added to the database and saved to the file.
Searching for a Movie:

When the user clicks on "Search by Title", a dialog prompts the user to enter a movie title. The system searches for matching titles in the database and displays the results in a message dialog.
Displaying All Movies:

Clicking on the "Display All Movies" button shows all movies in the database. If there are no movies, a message is displayed informing the user.
Exiting the Application:

When the user selects the "Exit" button, the program closes, and all data is saved to the file for the next time the application is opened.
Technologies Used:
Java: The core language used for the application.
Java Swing: Used to create the graphical user interface.
File Serialization: To persist movie data between application sessions.
Possible Future Enhancements:
Edit and Delete Movies: Add functionality for updating or removing movies from the database.
Advanced Search Options: Implement search by other fields like director or genre, or add filters like year ranges.
Sorting Movies: Add options to sort the movie list by title, year, or genre.
Database Integration: For a more scalable solution, integrate with a relational database like MySQL or SQLite.
