package StaffGroup;

public class PersonAward extends Award {
    private Person person;

    public PersonAward(String name, int year, String category, String offeredBy, Person person) {
        super(name, year, category, offeredBy);
        this.person = person;
        person.addAward(this);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
