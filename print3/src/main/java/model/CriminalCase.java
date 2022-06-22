package model;


import lombok.Data;
import model.enums.CaseStatus;
import model.enums.CaseType;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Criminal_Case")
@Data
public class CriminalCase extends AbstractEntity {
    @Column(name = "c_number")
    private String number;
    @Column(name = "c_type")
    private CaseType type;
    @Column(name = "c_short_des")
    private String short_des;
    @Column(name = "c_detail_des")
    private String detail_des;
    @Column(name = "c_status")
    @Enumerated
    private CaseStatus status;
    @Column(name = "c_notes")
    private String notes;
    @Transient
    private Set<Evidence> evidenceSet;
    @Column(name="c_lead_detective_id")
    private Detective leadInvestigator;
    @Transient
    private Set<Detective> assigned;

    public CriminalCase() {
    }

    public CriminalCase(long evidence_id, int version) {
    }
}