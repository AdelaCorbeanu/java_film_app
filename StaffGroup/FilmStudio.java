package StaffGroup;

import MovieGroup.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilmStudio {
    private String name;
    private List<Movie> movies = new ArrayList<>();
    private List<Person> founders = new ArrayList<>();
    private LocalDate date_founded;


    public FilmStudio(String name, List<Movie> movies, List<Person> founders, LocalDate date_founded) {
        this.name = name;
        if (!movies.isEmpty()) this.movies = movies;
        if (!founders.isEmpty()) this.founders = founders;
        this.date_founded = date_founded;
    }


    // name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    // movies
    public List<Movie> getMovies() {
        return movies;
    }
    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }


    // founders
    public List<Person> getFounders() {
        return founders;
    }
    public void addFounder(Person founder) {
        this.founders.add(founder);
    }


    // date founded
    public LocalDate getDateFounded() {
        return date_founded;
    }
    public void setDateFounded(LocalDate date_founded) {
        this.date_founded = date_founded;
    }
}
