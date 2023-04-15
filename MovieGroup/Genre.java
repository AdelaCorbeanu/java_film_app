package MovieGroup;

import java.util.ArrayList;
import java.util.List;

public enum Genre {
    ACTION(new ArrayList<>()),
    ADVENTURE(new ArrayList<>()),
    COMEDY(new ArrayList<>()),
    DRAMA(new ArrayList<>()),
    HORROR(new ArrayList<>()),
    ROMANCE(new ArrayList<>()),
    SCIENCE_FICTION(new ArrayList<>()),
    THRILLER(new ArrayList<>());

    private List<Movie> movies;

    Genre(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}

