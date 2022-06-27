package fis.project.print4.model;


import fis.project.print4.model.enums.TrackAction;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@Table
public class TrackEntry extends AbstractEntity{
    @Column(name = "date")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "evidence_Id")
    private Evidence evidence;
    @ManyToOne
    @JoinColumn(name = "detective")
    private Detective detective;
    @Column(name = "action")
    @Enumerated(EnumType.STRING)
    private TrackAction action;
    @Column(name = "reason")
    private String reason;

    public TrackEntry() {
    }

    public TrackEntry(long trackEntry_id, int service) {
    }
}
