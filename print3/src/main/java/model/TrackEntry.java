package model;


import lombok.Data;
import model.enums.TrackAction;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@Table
public class TrackEntry extends AbstractEntity{
    @Column(name = "tr_date")
    private LocalDateTime date;
    @Column(name = "tr_evidence")
    private Evidence evidence;
    @Column(name = "tr_detective")
    private Detective detective;
    @Column(name = "tr_action")
    @Enumerated
    private TrackAction action;
    @Column(name = "tr_reason")
    private String reason;

    public TrackEntry() {
    }

    public TrackEntry(long trackEntry_id, int service) {
    }
}
