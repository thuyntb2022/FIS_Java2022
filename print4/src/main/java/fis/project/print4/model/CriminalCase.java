package fis.project.print4.model;


import fis.project.print4.model.enums.CaseStatus;
import fis.project.print4.model.enums.CaseType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Criminal_Case")
@Data
public class CriminalCase extends AbstractEntity {
    @Column(name = "number")
    private String number;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CaseType type;
    @Column(name = "short_des")
    private String short_des;
    @Column(name = "etail_des")
    private String detail_des;
    @Column(name = "c_status")
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    @Column(name = "c_notes")
    private String notes;
    @OneToMany(mappedBy = "criminalCase")
    private Set<Evidence> evidenceSet;
    @ManyToOne
    @JoinColumn(name = "lead_detective_id")
    private Detective leadInvestigator;
    @Transient
    private Set<Detective> assigned;

    public CriminalCase() {
    }

    public CriminalCase(long criminalCase_id, int version) {
    }
}