package model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

@Entity
@Data
@Table(name = "evidence")
public class Evidence extends AbstractEntity {
    @Column(name = "e_criminalCase")
    private CriminalCase criminalCase;
    @Column(name = "e_storage")
    private Storage storage;
    @Column(name = "e_number")
    private String number;
    @Column(name = "e_itemName")
    private String itemName;
    @Column(name = "e_notes")
    private String notes;
    @Column(name = "e_archived")
    private Boolean archived;
    @Transient
    private Set<TrackEntry> trackEntries;

    public Evidence() {
    }

    public Evidence(long evidence_id, int version) {
    }
}
