package core.model;

import core.ICore.EmploymentStatus;
import core.ICore.Rank;

import java.util.Set;

public class Detective extends AbstractEntity {
    private Person person;
    private String badGetNumber;
    private Rank rank;
    private Boolean armed;
    private EmploymentStatus status;
    private Set<CriminalCase> criminalCase;
    private Set<TrackEntry> trackEntries;

    public Detective(long id, int version) {
        super(id,version);
    }

    public Detective(long id, int version,Person person, String badGetNumber, Boolean armed) {
        super(id, version);
        this.person = person;
        this.badGetNumber = badGetNumber;
        this.armed = armed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBadGetNumber() {
        return badGetNumber;
    }

    public void setBadGetNumber(String badGetNumber) {
        this.badGetNumber = badGetNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Set<CriminalCase> getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(Set<CriminalCase> criminalCase) {
        this.criminalCase = criminalCase;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }
}
