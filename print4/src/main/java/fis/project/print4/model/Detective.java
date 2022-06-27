package fis.project.print4.model;


import fis.project.print4.model.enums.EmploymentStatus;
import fis.project.print4.model.enums.Rank;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Data
@Table(name = "Detective")
public class Detective extends AbstractEntity{
    @Column(name = "badgeNumber")
    private String badgeNumber;
    @Column(name = "rank")
    @Enumerated(EnumType.STRING)
    private Rank rank;
    @Column(name = "armed")
    private Boolean armed;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;
    @Transient
    private Set<CriminalCase> criminalCases;
    @Transient
    private Set<TrackEntry> trackEntries;
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

    public Detective() {
    }

    public Detective(long detective_id, int version) {
    }
}
