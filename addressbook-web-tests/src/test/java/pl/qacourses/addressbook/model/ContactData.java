package pl.qacourses.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final String homeNumber;
    private final String email;
    private String group;

    public ContactData(String firstName, String lastName, String companyName, String homeNumber, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.homeNumber = homeNumber;
        this.email = email;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
