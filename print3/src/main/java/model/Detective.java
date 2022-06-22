package model;


import lombok.Data;
import model.enums.EmploymentStatus;
import model.enums.Rank;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@Table(name = "Detective")
public class Detective extends AbstractEntity{
    @Column(name = "d_person")
    private Person person;
    @Column(name = "d_badgeNumber")
    private String badgeNumber;
    @Column(name = "d_rank")
    @Enumerated
    private Rank rank;
    @Column(name = "d_armed")
    private Boolean armed;
    @Column(name = "d_status")
    @Enumerated
    private EmploymentStatus status;
    @Transient
    private Set<CriminalCase> criminalCases;
    @Transient
    private Set<TrackEntry> trackEntries;

    public Detective() {
    }

    public Detective(long detective_id, int version) {
    }
}
