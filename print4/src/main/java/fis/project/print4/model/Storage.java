package fis.project.print4.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;
@Entity
@Data
@Table(name = "Storage")
public class Storage extends AbstractEntity{
    private String name;
    private String location;
    @Transient
    private Set<Evidence> evidenceSet;
}
