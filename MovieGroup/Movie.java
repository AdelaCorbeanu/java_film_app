package MovieGroup;

import Intermediary.Printable;
import Intermediary.Role;
import StaffGroup.Award;
import StaffGroup.FilmStudio;
import StaffGroup.MovieAward;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Printable {
    private String title;
    private LocalDate release_date;
    private Language language;
    private String storyline;
    private Integer age_restriction;
    private List<Genre> genres = new ArrayList<>();
    private List<Role> directors = new ArrayList<>();
    private List<Role> producers = new ArrayList<>();
    private List<Role> writers = new ArrayList<>();
    private List<Role> actors = new ArrayList<>();
    private List<MovieAward> awards = new ArrayList<>();
    private FilmStudio studio;


    public Movie(String title, LocalDate releaseDate, Language language,
                 String storyline, Integer ageRestriction, List<Genre> genres,
                 List<Role> directors, List<Role> producers, List<Role> writers,
                 List<Role> actors, List<MovieAward> awards, FilmStudio studio) {
        this.title = title;
        this.release_date = releaseDate;
        this.language = language;
        this.storyline = storyline;
        this.age_restriction = ageRestriction;
        if (!genres.isEmpty()) this.genres = genres;
        if (!directors.isEmpty()) this.directors = directors;
        if (!producers.isEmpty()) this.producers = producers;
        if (!writers.isEmpty()) this.writers = writers;
        if (!actors.isEmpty()) this.actors = actors;
        if (!awards.isEmpty()) this.awards = awards;
        this.studio = studio;
        studio.addMovie(this);
        for (Genre genre : genres) {
            genre.addMovie(this);
        }
        for (MovieAward award : awards) {
            award.setMovie(this);
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
    public List<Role> getDirectors() {
        return directors;
    }
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


    // awards
    public List<MovieAward> getAwards() {
        return awards;
    }
    public void addAward(MovieAward award) {
        this.awards.add(award);
    }


    // studio
    public FilmStudio getStudio() {
        return studio;
    }
    public void setStudio(FilmStudio studio) {
        this.studio = studio;
    }


    @Override
    public String toString() {
        return  "Movie title: " + title + '\n' +
                "Release date: " + release_date + '\n' +
                "Language: " + language + '\n' +
                "Storyline: " + storyline + '\n' +
                "Age restriction: " + (age_restriction > 0 ? (age_restriction.toString() + "+") : "None") + '\n' +
                "Genres: " + genres + '\n' +
                "Directors: " + directors.stream()
                                .map(x -> x.getPerson().getName())
                                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) + '\n' +
                "Producers: " + producers.stream()
                                .map(x -> x.getPerson().getName())
                                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) + '\n' +
                "Writers: " + writers.stream()
                                .map(x -> x.getPerson().getName())
                                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) + '\n' +
                "Actors: " + actors.stream()
                                .map(x -> x.getPerson().getName())
                                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) + '\n' +
                "Awards: " + awards.stream()
                                .map(Award::getName)
                                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) + '\n' +
                "Film studio: " + studio.getName() + '\n';
    }
}
