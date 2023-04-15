package MovieGroup;

import StaffGroup.Person;
import org.jetbrains.annotations.NotNull;

public class Role {
    public enum RoleType { DIRECTOR, PRODUCER, WRITER, ACTOR };

    private final RoleType roleType;
    private final Movie movie;


    public Role(RoleType roleType, @NotNull Person person, @NotNull Movie movie) {
        this.roleType = roleType;
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
}
