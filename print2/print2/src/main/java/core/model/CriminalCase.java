package core.model;

import core.ICore.CaseStatus;
import core.ICore.CaseType;

import java.util.Set;

public class CriminalCase extends AbstractEntity{
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Set<Evidence> evidenceset;
    private Detective leadInVestigator;
    private Set<Detective> assigned;

    public CriminalCase(long id, int version) {
        super(id, version);
    }

    public CriminalCase(long id, int version, String number, CaseType type, String shortDescription, String detailedDescription,
                        CaseStatus status, String notes, Detective leadInVestigator) {
        super(id, version);
        this.number = number;
        this.type = type;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.leadInVestigator = leadInVestigator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Evidence> getEvidenceset() {
        return evidenceset;
    }

    public void setEvidenceset(Set<Evidence> evidenceset) {
        this.evidenceset = evidenceset;
    }

    public Detective getLeadInVestigator() {
        return leadInVestigator;
    }

    public void setLeadInVestigator(Detective leadInVestigator) {
        this.leadInVestigator = leadInVestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }
}
