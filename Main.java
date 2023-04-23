import Intermediary.Service;
import MovieGroup.Genre;
import MovieGroup.Language;
import MovieGroup.Movie;
import Intermediary.Role;
import StaffGroup.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        // tests here

        Service.introduceNewPerson("Stefan Diaconu", LocalDate.of(2002, 11, 22),
                Collections.emptyList(), Collections.emptyList());
        Service.introduceNewPerson("Andrei Lefter", LocalDate.of(2002, 4, 16),
                Collections.emptyList(), Collections.emptyList());
        Service.introduceNewPerson("Andrei Ancuta", LocalDate.of(2002, 3, 6),
                Collections.emptyList(), Collections.emptyList());

        Service.introduceNewFilmStudio("Mishu Entertainment", Collections.emptyList(),
                Collections.emptyList(), LocalDate.of(2013, 12, 12));
        Service.introduceNewFilmStudio("MinnieFilms", Collections.emptyList(),
                Collections.emptyList(), LocalDate.of(2012, 5, 10));

        Service.introduceNewMovie("American Psycho", LocalDate.of(2010, 3, 3), Language.ENGLISH,
                "Mishu goes on rampage", 15, List.of(Genre.HORROR, Genre.ACTION, Genre.DRAMA),
                Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
                Collections.emptyList(), Service.getStudioByPosition(1));

        Service.addStaff(Service.getPersonByPosition(1), Service.getMovieByPosition(1), Role.RoleType.DIRECTOR);
        Service.addStaff(Service.getPersonByPosition(2), Service.getMovieByPosition(1), Role.RoleType.PRODUCER);
        Service.addStaff(Service.getPersonByPosition(3), Service.getMovieByPosition(1), Role.RoleType.PRODUCER);
        Service.addStaff(Service.getPersonByPosition(2), Service.getMovieByPosition(1), Role.RoleType.WRITER);
        Service.addStaff(Service.getPersonByPosition(3), Service.getMovieByPosition(1), Role.RoleType.ACTOR);

        Service.awardMovie("Literally Me Prize", 2023, "Drama", "Ryan Gosling Institute", Service.getMovieByPosition(1));
//        Service.listMoviesByNewest();


        // interactive menu here

        List<String> commands = List.of("1. See information\n",
                                        "2. Add information\n",
                                        "3. Delete information\n",
                                        "4. End session\n");
        List<String> seeInfoOptions = List.of("1. Movies\n",
                                              "2. People\n",
                                              "3. Film Studios\n",
                                              "4. End operation\n");
        List<String> movieInfoOptions = List.of("1. List all movies alphabetically\n",
                                                "2. List all movies from newest to oldest\n",
                                                "3. List all movie awards\n",
                                                "4. End operation\n");
        List<String> peopleInfoOptions = List.of("1. List all people alphabetically\n",
                                                 "2. List movies a person has worked on\n",
                                                 "3. List person's awards\n",
                                                 "4. End operation\n");

        System.out.println("The commands available are:\n");
        commands.forEach(System.out::print);
        System.out.println("Please enter the corresponding number:\n");

        Set<Integer> validInput = new HashSet<>();
        validInput.add(1);
        validInput.add(2);
        validInput.add(3);
        validInput.add(4);

        Scanner s = new Scanner(System.in);
        int cmd = s.nextInt();
        while (cmd != 4) {
            try {
                if (!validInput.contains(cmd)) {
                    throw new InvalidInputException("Invalid input! Input should be part of: " + validInput);
                }
            }
            catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                System.out.println("The commands available are:\n");
                commands.forEach(System.out::print);
                System.out.println("Please enter the corresponding number:\n");
                cmd = s.nextInt();
                continue;
            }

            switch (cmd) {
                // see info
                case 1 -> {
                    System.out.println("See information about: ");
                    seeInfoOptions.forEach(System.out::print);
                    System.out.println("Please enter the corresponding number:\n");
                    cmd = s.nextInt();
                    while (true) {
                        try {
                            if (!validInput.contains(cmd)) {
                                throw new InvalidInputException("Invalid input! Input should be part of: " + validInput);
                            }
                            else break;
                        }
                        catch (InvalidInputException e) {
                            System.out.println(e.getMessage());
                            System.out.println("The commands available are:\n");
                            seeInfoOptions.forEach(System.out::print);
                            System.out.println("Please enter the corresponding number:\n");
                            cmd = s.nextInt();
                        }
                    }

                    switch (cmd) {
                        // info about movies
                        case 1 -> {
                            System.out.println("Choose what you would like to see:\n");
                            movieInfoOptions.forEach(System.out::print);
                            System.out.println("Please enter the corresponding number:\n");
                            cmd = s.nextInt();
                            while (true) {
                                try {
                                    if (!validInput.contains(cmd)) {
                                        throw new InvalidInputException("Invalid input! Input should be part of: " + validInput);
                                    }
                                    else break;
                                }
                                catch (InvalidInputException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("The commands available are:\n");
                                    movieInfoOptions.forEach(System.out::print);
                                    System.out.println("Please enter the corresponding number:\n");
                                    cmd = s.nextInt();
                                }
                            }
                            switch (cmd) {
                                // movies alphabetically
                                case 1 -> {
                                    System.out.println("These are all the movies in alphabetical order:\n");
                                    Service.listMoviesAlphabetically();
                                    System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                }
                                // movies newest
                                case 2 -> {
                                    System.out.println("These are all the movies in chronological order:\n");
                                    Service.listMoviesByNewest();
                                    System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                }
                                // awards of all movies
                                case 3 -> {
                                    System.out.println("These are all the awards of movies:\n");
                                    Service.listMovieAwards();
                                    System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                }
                                case 4 -> {}
                            }
                        }
                        // info about people
                        case 2 -> {
                            System.out.println("Choose what you would like to see:\n");
                            peopleInfoOptions.forEach(System.out::print);
                            System.out.println("Please enter the corresponding number:\n");
                            cmd = s.nextInt();
                            while (true) {
                                try {
                                    if (!validInput.contains(cmd)) {
                                        throw new InvalidInputException("Invalid input! Input should be part of: " + validInput);
                                    }
                                    else break;
                                }
                                catch (InvalidInputException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("The commands available are:\n");
                                    peopleInfoOptions.forEach(System.out::print);
                                    System.out.println("Please enter the corresponding number:\n");
                                    cmd = s.nextInt();
                                }
                            }
                            switch (cmd) {
                                // people alphabetically
                                case 1 -> {
                                    System.out.println("These are all the people in alphabetical order:\n");
                                    Service.listPeopleAlphabetically();
                                    System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                }
                                // movies of given person
                                case 2 -> {
                                    System.out.println("These are all the people in alphabetical order:\n");
                                    Service.listPeopleAlphabetically();
                                    System.out.println("Please choose the number of your person:\n");
                                    cmd = s.nextInt();
                                    Person person = Service.getPersonByPosition(cmd);
                                    System.out.println("Which movies of " + person.getName() + "do you want to see?");
                                    System.out.println("1. Directed\n2. Produced\n3. Written\n4. Acted\n5. Abort operation");
                                    cmd = s.nextInt();
                                    switch (cmd) {
                                        case 1 -> {
                                            System.out.println("These are the movies directed by " + person.getName() + ":");
                                            Service.listFilmsDirectedByPerson(person);
                                            System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                        }
                                        case 2 -> {
                                            System.out.println("These are the movies produced by " + person.getName() + ":");
                                            Service.listFilmsProducedByPerson(person);
                                            System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                        }
                                        case 3 -> {
                                            System.out.println("These are the movies written by " + person.getName() + ":");
                                            Service.listFilmsWrittenByPerson(person);
                                            System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                        }
                                        case 4 -> {
                                            System.out.println("These are the movies " + person.getName() + " played in:");
                                            Service.listFilmsPlayedByPerson(person);
                                            System.out.println("Your operation has been successfully completed! You will be returned to the initial menu.\n");
                                        }
                                        case 5 -> {}
                                    }
                                }
                                // given person's awards
                                case 3 -> {
                                    System.out.println("These are all the people in alphabetical order:\n");
                                    Service.listPeopleAlphabetically();
                                    System.out.println("Please choose the number of your person:\n");
                                    cmd = s.nextInt();
                                    Person person = Service.getPersonByPosition(cmd);
                                    System.out.println("These are the awards of " + person.getName());
                                    Service.listPersonAwards(person);
                                }
                                case 4 -> {}
                            }
                        }
                        // info about film studios
                        case 3 -> {
                            System.out.println("These are all the film studios:\n");
                            Service.listFilmStudios();
                        }
                        case 4 -> {}
                    }
                }
                // add info
                case 2 -> {
                    System.out.println("Add information about: ");
                    seeInfoOptions.forEach(System.out::print);
                    System.out.println("Please enter the corresponding number:\n");
                    cmd = s.nextInt();
                    while (true) {
                        try {
                            if (!validInput.contains(cmd)) {
                                throw new InvalidInputException("Invalid input! Input should be part of: " + validInput);
                            }
                            else break;
                        }
                        catch (InvalidInputException e) {
                            System.out.println(e.getMessage());
                            System.out.println("The commands available are:\n");
                            seeInfoOptions.forEach(System.out::print);
                            System.out.println("Please enter the corresponding number:\n");
                            cmd = s.nextInt();
                        }
                    }
                    switch (cmd) {
                        // add info about movies
                        case 1 -> {
                            System.out.println("Choose what you want to do:\n");
                            System.out.println("1. Add movie\n2. Add staff\n3. Add award\n4.Abort operation\n");
                            cmd = s.nextInt();
                            switch (cmd) {
                                // add movie
                                case 1 -> {
                                    String title; LocalDate releaseDate; Language language;
                                    String storyline; int ageRestriction; List<Genre> genres = new ArrayList<>();
                                    List<Role> directors = new ArrayList<>(); List<Role> producers = new ArrayList<>(); List<Role> writers = new ArrayList<>();
                                    List<Role> actors = new ArrayList<>(); List<MovieAward> awards = new ArrayList<>(); FilmStudio studio;

                                    System.out.println("Introduce title:");
                                    title = s.nextLine();
                                    title = s.nextLine();

                                    System.out.println("\nIntroduce release date (yyyy-mm-dd):");
                                    String stringDate = s.nextLine();

                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                    releaseDate = LocalDate.parse(stringDate, formatter);

                                    System.out.println("\nIntroduce the language in UPPERCASE (you can also choose MIX):");
                                    language = Language.valueOf(s.nextLine());

                                    System.out.println("\nIntroduce storyline:");
                                    storyline = s.nextLine();

                                    System.out.println("\nIntroduce age restriction:");
                                    ageRestriction = s.nextInt();

                                    System.out.println("\nHow many genres does the movie have?");

                                    int genreCnt = s.nextInt();
                                    String aux = s.nextLine();
                                    while (genreCnt > 0) {
                                        System.out.println("Introduce genre in UPPERCASE:");
                                        genres.add(Genre.valueOf(s.nextLine()));
                                        genreCnt--;
                                    }

                                    System.out.println("\nChoose the studio from the next list:");
                                    Service.listFilmStudios();
                                    cmd = s.nextInt();
                                    studio = Service.getStudioByPosition(cmd);

                                    Service.introduceNewMovie(title, releaseDate, language, storyline, ageRestriction, genres, directors, producers, writers, actors, awards, studio);
                                    System.out.println("Your movie has been added. You can go to the add staff section to add crew members.");
                                }
                                // add staff
                                case 2 -> {
                                    System.out.println("Choose your movie:");
                                    Service.listMoviesAlphabetically();
                                    cmd = s.nextInt();
                                    Movie movie = Service.getMovieByPosition(cmd);

                                    System.out.println("What do you want to add?");
                                    System.out.println("1. Person\n2. Film Studio\n3. End operation");
                                    cmd = s.nextInt();
                                    switch (cmd) {
                                        // link person to movie
                                        case 1 -> {
                                            System.out.println("Choose your person:");
                                            Service.listPeopleAlphabetically();
                                            cmd = s.nextInt();
                                            Person person = Service.getPersonByPosition(cmd);
                                            System.out.println("Choose the role:");
                                            System.out.println("1. Director\n2. Producer\n3. Writer\n4. Actor");
                                            cmd = s.nextInt();
                                            switch (cmd) {
                                                case 1 -> {
                                                    Service.addStaff(person, movie, Role.RoleType.DIRECTOR);
                                                }
                                                case 2 -> {
                                                    Service.addStaff(person, movie, Role.RoleType.PRODUCER);
                                                }
                                                case 3 -> {
                                                    Service.addStaff(person, movie, Role.RoleType.WRITER);
                                                }
                                                case 4 -> {
                                                    Service.addStaff(person, movie, Role.RoleType.ACTOR);
                                                }
                                            }
                                        }
                                        // link studio to movie
                                        case 2 -> {
                                            System.out.println("Choose your studio:");
                                            Service.listFilmStudios();
                                            cmd = s.nextInt();
                                            FilmStudio studio = Service.getStudioByPosition(cmd);
                                            Service.addStaff(studio, movie);
                                        }
                                    }
                                }
                                // give award to movie
                                case 3 -> {
                                    System.out.println("Choose your movie:");
                                    Service.listMoviesAlphabetically();
                                    cmd = s.nextInt();
                                    Movie movie = Service.getMovieByPosition(cmd);

                                    String name; int year; String category; String offeredBy;
                                    System.out.println("\nIntroduce award title:");
                                    name = s.nextLine();
                                    name = s.nextLine();

                                    System.out.println("\nIntroduce category:");
                                    category = s.nextLine();

                                    System.out.println("\nIntroduce year:");
                                    year = s.nextInt();

                                    System.out.println("\nWho offered the award?");
                                    offeredBy = s.nextLine();
                                    offeredBy = s.nextLine();

                                    Service.awardMovie(name, year, category, offeredBy, movie);
                                }
                                case 4 -> {}
                            }
                        }
                        // add info about people
                        case 2 -> {
                            System.out.println("Choose what you want to do:\n");
                            System.out.println("1. Add person\n2. Add award\n3. Abort operation\n");
                            cmd = s.nextInt();
                            switch (cmd) {
                                // add person
                                case 1 -> {
                                    String name; LocalDate date_of_birth;
                                    List<Role> roles = new ArrayList<>(); List<PersonAward> awards = new ArrayList<>();
                                    System.out.println("Introduce name:");
                                    name = s.nextLine();
                                    name = s.nextLine();

                                    System.out.println("Introduce birth date (yyyy-mm-dd):");
                                    String stringDate = s.nextLine();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                    date_of_birth = LocalDate.parse(stringDate, formatter);

                                    Service.introduceNewPerson(name, date_of_birth, roles, awards);
                                    System.out.println("Your person has been introduced. You can go to section add info -> movies -> add staff to add roles.");
                                }
                                // add award
                                case 2 -> {
                                    System.out.println("Choose your person:");
                                    Service.listPeopleAlphabetically();
                                    cmd = s.nextInt();
                                    Person person = Service.getPersonByPosition(cmd);

                                    String name; int year; String category; String offeredBy;
                                    System.out.println("\nIntroduce award title:");
                                    name = s.nextLine();
                                    name = s.nextLine();

                                    System.out.println("\nIntroduce category:");
                                    category = s.nextLine();

                                    System.out.println("\nIntroduce year:");
                                    year = s.nextInt();

                                    System.out.println("\nWho offered the award?");
                                    offeredBy = s.nextLine();
                                    offeredBy = s.nextLine();

                                    Service.awardPerson(name, year, category, offeredBy, person);
                                }
                                case 3 -> {}
                            }
                        }
                        // add info about film studios
                        case 3 -> {
                            System.out.println("Choose what you want to do:");
                            System.out.println("1. Add film studio\n2. Add studio founder\n3. Abort operation");
                            cmd = s.nextInt();
                            switch (cmd) {
                                // add film studio
                                case 1 -> {
                                    String name; List<Movie> movies = new ArrayList<>();
                                    List<Person> founders = new ArrayList<>(); LocalDate date_founded;
                                    System.out.println("Introduce name:");
                                    name = s.nextLine();
                                    name = s.nextLine();

                                    System.out.println("When was the studio founded? (yyyy-mm-dd):");
                                    String stringDate = s.nextLine();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                    date_founded = LocalDate.parse(stringDate, formatter);

                                    Service.introduceNewFilmStudio(name, movies, founders, date_founded);
                                    System.out.println("Your studio has been added. Navigate to add info -> movies -> add staff to link the studio to its movies");
                                }
                                // add studio founder
                                case 2 -> {
                                    System.out.println("Choose your studio:");
                                    Service.listFilmStudios();
                                    cmd = s.nextInt();
                                    FilmStudio studio = Service.getStudioByPosition(cmd);

                                    System.out.println("Choose your person:");
                                    Service.listPeopleAlphabetically();
                                    cmd = s.nextInt();
                                    Person person = Service.getPersonByPosition(cmd);

                                    Service.addStaff(person, studio);
                                    System.out.println("Founder added successfully.");
                                }
                                case 3 -> {}
                            }
                        }
                        case 4 -> {}
                    }
                }
            }
            // read next command
            System.out.println("The commands available are:\n");
            commands.forEach(System.out::print);
            System.out.println("Please enter the corresponding number:\n");
            cmd = s.nextInt();
        }
    }
}