package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "guest", name = "workers")
@PrimaryKeyJoinColumn (name = "PK_workers_id")
public class Workers extends User {

    LocalDate startJob;
    LocalDate endJob;
    String job_post;
    double moneyMonth; // зп

}
