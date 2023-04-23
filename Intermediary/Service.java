package Intermediary;

import MovieGroup.Genre;
import MovieGroup.Language;
import MovieGroup.Movie;
import StaffGroup.*;

import java.time.LocalDate;
import java.util.*;

public class Service {
    private static List<Movie> movieList = new ArrayList<>();
    private static List<Person> peopleList = new ArrayList<>();
    private static List<Award> awardList = new ArrayList<>();
    private static List<FilmStudio> studioList = new ArrayList<>();

    public static void introduceNewMovie(String title, LocalDate releaseDate, Language language,
                                         String storyline, Integer ageRestriction, List<Genre> genres,
                                         List<Role> directors, List<Role> producers, List<Role> writers,
                                         List<Role> actors, List<MovieAward> awards, FilmStudio studio) {
        Movie movie = new Movie(title, releaseDate, language, storyline, ageRestriction,
                genres, directors, producers, writers, actors, awards, studio);
        movieList.add(movie);
        awardList.addAll(awards);
    }

    public static void introduceNewPerson(String name, LocalDate date_of_birth, List<Role> roles, List<PersonAward> awards) {
        Person person = new Person(name, date_of_birth, roles, awards);
        peopleList.add(person);
    }

    public static void introduceNewFilmStudio(String name, List<Movie> movies, List<Person> founders, LocalDate date_founded) {
        FilmStudio studio = new FilmStudio(name, movies, founders, date_founded);
        studioList.add(studio);
    }

    public static void awardMovie(String name, int year, String category, String offeredBy, Movie movie) {
        MovieAward award = new MovieAward(name, year, category, offeredBy, movie);
        awardList.add(award);
    }

    public static void awardPerson(String name, int year, String category, String offeredBy, Person person) {
        PersonAward award = new PersonAward(name, year, category, offeredBy, person);
        awardList.add(award);
    }

    public static void listMoviesAlphabetically() {
        movieList.sort(Comparator.comparing(Movie::getTitle));
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i+1) + ":\n" + movieList.get(i) + '\n');
        }
    }

    public static void listMoviesByNewest() {
        movieList.sort(Comparator.comparing(Movie::getReleaseDate).reversed());
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i+1) + ":\n" + movieList.get(i) + '\n');
        }
    }

    public static Movie getMovieByPosition(int position) {
        return movieList.get(position - 1);
    }

    public static void listPeopleAlphabetically() {
        peopleList.sort(Comparator.comparing(Person::getName));
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.println((i+1) + ":\n" + peopleList.get(i) + '\n');
        }
    }

    public static Person getPersonByPosition(int position) {
        return peopleList.get(position - 1);
    }

    public static void listFilmsDirectedByPerson(Person person) {
        List<Movie> directedMovies = person.getDirectedMovies();
        System.out.println("Movies directed by " + person.getName() + ":\n");
        for (int i = 0; i < directedMovies.size(); i++) {
            System.out.println((i+1) + ":\n" + directedMovies.get(i) + '\n');
        }
    }

    public static void listFilmsProducedByPerson(Person person) {
        List<Movie> producedMovies = person.getProducedMovies();
        System.out.println("Movies produced by " + person.getName() + ":\n");
        for (int i = 0; i < producedMovies.size(); i++) {
            System.out.println((i+1) + ":\n" + producedMovies.get(i) + '\n');
        }
    }

    public static void listFilmsWrittenByPerson(Person person) {
        List<Movie> writtenMovies = person.getWrittenMovies();
        System.out.println("Movies written by " + person.getName() + ":\n");
        for (int i = 0; i < writtenMovies.size(); i++) {
            System.out.println((i+1) + ":\n" + writtenMovies.get(i) + '\n');
        }
    }

    public static void listFilmsPlayedByPerson(Person person) {
        List<Movie> playedMovies = person.getPlayedMovies();
        System.out.println("Movies played by " + person.getName() + ":\n");
        for (int i = 0; i < playedMovies.size(); i++) {
            System.out.println((i+1) + ":\n" + playedMovies.get(i) + '\n');
        }
    }

    public static void listFilmStudios() {
        int j = 1;
        for (FilmStudio studio : studioList) {
            List<String> founders = new ArrayList<>();
            for (Person person : studio.getFounders()) {
                founders.add(person.getName());
            }
            System.out.println(j + ".\n");
            System.out.println("Film Studio: " + studio.getName());
            System.out.println("Founded: " + studio.getDateFounded());
            System.out.println("Founders: " + founders);
            System.out.println("Movies:");
            for (int i = 0; i < studio.getMovies().size(); i++) {
                System.out.println(studio.getMovies().get(i).getTitle() + '\n');
            }
            if (studio.getMovies().size() == 0) {
                System.out.println("No movies yet.");
            }
            j += 1;
        }
    }

    public static FilmStudio getStudioByPosition(int position) {
        return studioList.get(position - 1);
    }

    public static void listMovieAwards() {
        for (Award award : awardList) {
            if (award instanceof MovieAward movieAward) {
                System.out.println("Award ~ " + movieAward.getName() + " " + movieAward.getYear()
                        + "\nCategory: " + movieAward.getCategory()
                        + "\nOffered by: " + movieAward.getOfferedBy()
                        + "\nMovie: " + movieAward.getMovie().getTitle());
            }
        }
    }

    public static void listPersonAwards() {
        for (Award award : awardList) {
            if (award instanceof PersonAward personAward) {
                System.out.println("Award ~ " + personAward.getName() + " " + personAward.getYear()
                        + "\nCategory: " + personAward.getCategory()
                        + "\nOffered by: " + personAward.getOfferedBy()
                        + "\nPerson: " + personAward.getPerson().getName());
            }
        }
    }

    public static void listPersonAwards(Person person) {
        for (Award award : awardList) {
            if (award instanceof PersonAward personAward && ((PersonAward) award).getPerson() == person) {
                System.out.println("Award ~ " + personAward.getName() + " " + personAward.getYear()
                        + "\nCategory: " + personAward.getCategory()
                        + "\nOffered by: " + personAward.getOfferedBy());
            }
        }
    }

    public static void addStaff(Person person, Movie movie, Role.RoleType roleType) {
        new Role(roleType, person, movie);
    }

    public static void addStaff(Person person, FilmStudio studio) {
        studio.addFounder(person);
    }

    public static void addStaff(FilmStudio studio, Movie movie) {
        movie.setStudio(studio);
    }

    public static void deleteEntity(Movie movie, int position) {
        movieList.remove(position);
    }

    public static void deleteEntity(Person person, int position) {
        peopleList.remove(position);
    }

    public static void deleteEntity(FilmStudio filmStudio, int position) {
        studioList.remove(position);
    }
}
