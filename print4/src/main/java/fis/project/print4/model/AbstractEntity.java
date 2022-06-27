package fis.project.print4.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@MappedSuperclass
@Data
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "version")
    private int version;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "modifisedAt")
    private LocalDateTime modifisedAt;


}
