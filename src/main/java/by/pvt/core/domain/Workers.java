package by.pvt.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "guest", name = "workers")
@PrimaryKeyJoinColumn(name = "PK_workers_id")
public class Workers
    {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startJob;
    private LocalDate endJob;
    private String job_post;
    private double moneyMonth; // зп

    }
