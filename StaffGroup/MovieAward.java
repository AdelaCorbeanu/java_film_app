package StaffGroup;

import MovieGroup.Movie;

public class MovieAward extends Award{
    private Movie movie;

    public MovieAward(String name, int year, String category, String offeredBy, Movie movie) {
        super(name, year, category, offeredBy);
        this.movie = movie;
        movie.addAward(this);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
