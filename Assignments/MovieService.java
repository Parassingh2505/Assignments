package Assignments;

import java.time.LocalDate;
import java.util.*;

class Movie implements Comparable<Movie> {
    private int movieId;
    private String movieName;
    private String genre;
    private LocalDate releaseDate;

    public Movie(int movieId, String movieName, String genre, LocalDate releaseDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Movie ID: " + movieId + ", Name: " + movieName + ", Genre: " + genre + ", Release Date: " + releaseDate;
    }

    @Override
    public int compareTo(Movie otherMovie) {
        return this.releaseDate.compareTo(otherMovie.releaseDate);
    }
}

public class MovieService {
    public Set<Map.Entry<Movie, Integer>> addKeyValuePairsToMap(Movie movie, Integer rating) {
        // Create a new HashMap and add the movie and rating as key-value pair
        HashMap<Movie, Integer> movieMap = new HashMap<>();
        movieMap.put(movie, rating);
        // Return the entry set of the HashMap
        return movieMap.entrySet();
    }

    public List<String> getHigherRatedMovieNames(Map<Movie, Integer> movieMap) {
        List<String> higherRatedMovies = new ArrayList<>();
        for (Map.Entry<Movie, Integer> entry : movieMap.entrySet()) {
            if (entry.getValue() > 3) {
                higherRatedMovies.add(entry.getKey().getMovieName());
            }
        }
        return higherRatedMovies;
    }

    public List<String> getMovieNamesOfSpecificGenre(Map<Movie, Integer> movieMap, String genre) {
        List<String> specificGenreMovies = new ArrayList<>();
        for (Map.Entry<Movie, Integer> entry : movieMap.entrySet()) {
            if (entry.getKey().getGenre().equalsIgnoreCase(genre)) {
                specificGenreMovies.add(entry.getKey().getMovieName());
            }
        }
        return specificGenreMovies;
    }

    public List<String> getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(
            Map<Movie, Integer> movieMap, LocalDate releaseDate) {
        List<String> filteredMovies = new ArrayList<>();
        for (Map.Entry<Movie, Integer> entry : movieMap.entrySet()) {
            if (entry.getKey().getReleaseDate().isAfter(releaseDate) && entry.getValue() < 3) {
                filteredMovies.add(entry.getKey().getMovieName());
            }
        }
        return filteredMovies;
    }

    public List<Movie> getSortedMovieListByReleaseDate(Map<Movie, Integer> movieMap) {
        List<Movie> sortedMovies = new ArrayList<>(movieMap.keySet());
        sortedMovies.sort(Comparator.naturalOrder());
        return sortedMovies;
    }

    public Map<Movie, Integer> getSortedMovieListByRating(Map<Movie, Integer> movieMap) {
        // Create a list from the entry set of the map
        List<Map.Entry<Movie, Integer>> entryList = new ArrayList<>(movieMap.entrySet());
        // Sort the list based on ratings in descending order
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        // Create a LinkedHashMap to store the sorted entries
        LinkedHashMap<Movie, Integer> sortedMap = new LinkedHashMap<>();
        // Put sorted entries into the LinkedHashMap
        for (Map.Entry<Movie, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        // Create some movie objects
        Movie movie1 = new Movie(1, "Movie A", "Action", LocalDate.of(2022, 5, 15));
        Movie movie2 = new Movie(2, "Movie B", "Comedy", LocalDate.of(2021, 10, 8));
        Movie movie3 = new Movie(3, "Movie C", "Drama", LocalDate.of(2023, 2, 20));
        Movie movie4 = new Movie(4, "Movie D", "Action", LocalDate.of(2021, 12, 5));

        // Create a map of movies and ratings
        Map<Movie, Integer> movieMap = new HashMap<>();
        movieMap.put(movie1, 4);
        movieMap.put(movie2, 5);
        movieMap.put(movie3, 3);
        movieMap.put(movie4, 2);

        MovieService service = new MovieService();

        // Test the methods and print the expected output
        System.out.println("Higher Rated Movie Names: " + service.getHigherRatedMovieNames(movieMap));
        System.out.println("Movie Names of Genre 'Action': " + service.getMovieNamesOfSpecificGenre(movieMap, "Action"));
        System.out.println("Movies Released After 2022-01-01 and Rating Less Than 3: " +
                service.getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(movieMap, LocalDate.of(2022, 1, 1)));
        System.out.println("Sorted Movie List By Release Date: " + service.getSortedMovieListByReleaseDate(movieMap));
        System.out.println("Sorted Movie List By Rating: " + service.getSortedMovieListByRating(movieMap));
    }
}
