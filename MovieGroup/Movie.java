package MovieGroup;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private String title;
    private LocalDate release_date;
    private Language language;
    private String storyline;
    private Integer age_restriction;
    private List<Genre> genres;
    private List<Role> directors;
    private List<Role> producers;
    private List<Role> writers;
    private List<Role> actors;


    public Movie(String title, LocalDate releaseDate, Language language,
                 String storyline, Integer ageRestriction, List<Genre> genres,
                 List<Role> directors, List<Role> producers, List<Role> writers,
                 List<Role> actors) {
        this.title = title;
        this.release_date = releaseDate;
        this.language = language;
        this.storyline = storyline;
        this.age_restriction = ageRestriction;
        this.genres = genres;
        this.directors = directors;
        this.producers = producers;
        this.writers = writers;
        this.actors = actors;
        for (Genre genre : this.genres) {
            genre.addMovie(this);
        }
    }


    // add staff people
    public void addRole(Role role) {
        switch (role.getRoleType()) {
            case DIRECTOR -> addDirector(role);
            case PRODUCER -> addProducer(role);
            case WRITER -> addWriter(role);
            case ACTOR -> addActor(role);
        }
    }
    public void addDirector(Role role) {
        directors.add(role);
    }
    public void addProducer(Role role) {
        producers.add(role);
    }
    public void addWriter(Role role) {
        writers.add(role);
    }
    public void addActor(Role role) {
        actors.add(role);
    }


    // genre
    public List<Genre> getGenres() {
        return genres;
    }
    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }


    // age restriction
    public Integer getAgeRestriction() {
        return age_restriction;
    }
    public void setAgeRestriction(Integer age_restriction) {
        this.age_restriction = age_restriction;
    }


    // storyline
    public String getStoryline() {
        return storyline;
    }
    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }


    // get staff
    public List<Role> getProducers() {
        return producers;
    }
    public List<Role> getWriters() {
        return writers;
    }
    public List<Role> getActors() {
        return actors;
    }


    // language
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }


    // title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    // release date
    public LocalDate getReleaseDate() {
        return release_date;
    }
    public void setReleaseDate(LocalDate release_date) {
        this.release_date = release_date;
    }

}
