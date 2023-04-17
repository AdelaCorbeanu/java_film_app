import MovieGroup.Genre;
import MovieGroup.Language;
import MovieGroup.Movie;
import Intermediary.Role;
import StaffGroup.Award;
import StaffGroup.FilmStudio;
import StaffGroup.Person;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // tests here

        Person p1 = new Person("Stefan Diaconu", LocalDate.of(2002, 11, 22),
                Collections.emptyList(), Collections.emptyList());
        Person p2 = new Person("Andrei Lefter", LocalDate.of(2002, 4, 16),
                Collections.emptyList(), Collections.emptyList());
        Person p3 = new Person("Andrei Ancuta", LocalDate.of(2002, 3, 6),
                Collections.emptyList(), Collections.emptyList());

        FilmStudio s1 = new FilmStudio("Mishu Entertainment", Collections.emptyList(),
                Collections.emptyList(), LocalDate.of(2013, 12, 12));
        FilmStudio s2 = new FilmStudio("MinnieFilms", Collections.emptyList(),
                Collections.emptyList(), LocalDate.of(2012, 5, 10));

        Movie m1 = new Movie("American Psycho", LocalDate.of(2010, 3, 3), Language.ENGLISH,
                "Mishu goes on rampage", 15, List.of(Genre.HORROR, Genre.ACTION, Genre.DRAMA),
                Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
                Collections.emptyList(), s1);

        Role r1 = new Role(Role.RoleType.DIRECTOR, p1, m1);
        Role r2 = new Role(Role.RoleType.PRODUCER, p2, m1);
        Role r3 = new Role(Role.RoleType.PRODUCER, p3, m1);
        Role r4 = new Role(Role.RoleType.WRITER, p2, m1);
        Role r5 = new Role(Role.RoleType.ACTOR, p3, m1);

        Award a1 = new Award("Literally Me Prize", 2023, "Drama", "Ryan Gosling Institute");
        m1.addAward(a1);

        System.out.println(m1);
    }
}
