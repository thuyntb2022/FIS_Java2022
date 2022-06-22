package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "person")
public class Person {
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "password")
    private String password;
    @Column(name = "hiring_date")
    private LocalDateTime hiring_date;
}
