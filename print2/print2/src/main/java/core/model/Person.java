package core.model;

import java.time.LocalDateTime;

public class Person extends AbstractEntity{
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime hiringDate;

    public Person(long id, int version, String userName, String firstName, String lastName, String password) {
        super(id, version);
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = java.time.LocalDateTime.now();
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
