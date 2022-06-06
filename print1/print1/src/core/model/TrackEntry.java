package core.model;

import core.ICore.TrackAction;
import core.model.Detective;
import core.model.Evidence;

import java.time.LocalDateTime;

public class TrackEntry extends AbstractEntity{
    private LocalDateTime date;
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String reason;

    public TrackEntry(Evidence evidence, Detective detective, TrackAction action, String reason) {
        this.evidence = evidence;
        this.detective = detective;
        this.action = action;
        this.reason = reason;
        this.date = java.time.LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Detective getDetective() {
        return detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    public TrackAction getAction() {
        return action;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
