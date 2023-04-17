package StaffGroup;

public class Award {
    private String name;
    private int year;
    private String category;
    private String offeredBy;


    public Award(String name, int year, String category, String offeredBy) {
        this.name = name;
        this.year = year;
        this.category = category;
        this.offeredBy = offeredBy;
    }


    // name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // year
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // category
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    // who offered it
    public String getOfferedBy() {
        return offeredBy;
    }
    public void setOfferedBy(String offeredBy) {
        this.offeredBy = offeredBy;
    }
}

