package fis.project.print4.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "evidence")
public class Evidence extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "criminalCase_id")
    private CriminalCase criminalCase;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
    @Column(name = "number")
    private String number;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "notes")
    private String notes;
    @Column(name = "archived")
    private Boolean archived;
    @Transient
    private Set<TrackEntry> trackEntries;

    public Evidence() {
    }

    public Evidence(long evidence_id, int version) {
    }
}
