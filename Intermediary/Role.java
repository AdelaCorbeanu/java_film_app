package Intermediary;

import MovieGroup.Movie;
import StaffGroup.Person;
import org.jetbrains.annotations.NotNull;

public class Role implements Printable{
    public enum RoleType { DIRECTOR, PRODUCER, WRITER, ACTOR };

    private final RoleType roleType;
    private final Movie movie;
    private final Person person;


    public Role(RoleType roleType, @NotNull Person person, @NotNull Movie movie) {
        this.roleType = roleType;
        this.person = person;
        this.movie = movie;
        person.addRole(this);
        movie.addRole(this);
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Movie getMovie() {
        return movie;
    }

    public Person getPerson() {
        return person;
    }


    @Override
    public String toString() {
        return movie.getTitle() + roleType;
    }
}
