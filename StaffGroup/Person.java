package StaffGroup;

import MovieGroup.Movie;
import MovieGroup.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private LocalDate date_of_birth;
    private List<Role> roles;


    public Person(String name, LocalDate date_of_birth, List<Role> roles) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.roles = roles;
    }


    public void addRole(Role role) {
        roles.add(role);
    }


    // name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    // date of birth
    public LocalDate getDateOfBirth() {
        return date_of_birth;
    }
    public void setDateOfBirth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    // related movies
    public List<Movie> getDirectedMovies() {
        List<Movie> directedMovies = new ArrayList<>();
        for (Role role : roles) {
            if (role.getRoleType() == Role.RoleType.DIRECTOR) {
                directedMovies.add(role.getMovie());
            }
        }
        return directedMovies;
    }
    public List<Movie> getProducedMovies() {
        List<Movie> producedMovies = new ArrayList<>();
        for (Role role : roles) {
            if (role.getRoleType() == Role.RoleType.PRODUCER) {
                producedMovies.add(role.getMovie());
            }
        }
        return producedMovies;
    }
    public List<Movie> getWrittenMovies() {
        List<Movie> writtenMovies = new ArrayList<>();
        for (Role role : roles) {
            if (role.getRoleType() == Role.RoleType.WRITER) {
                writtenMovies.add(role.getMovie());
            }
        }
        return writtenMovies;
    }
    public List<Movie> getPlayedMovies() {
        List<Movie> playedMovies = new ArrayList<>();
        for (Role role : roles) {
            if (role.getRoleType() == Role.RoleType.ACTOR) {
                playedMovies.add(role.getMovie());
            }
        }
        return playedMovies;
    }
}
