package by.pvt.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalDate;
@Data
@Entity
@NoArgsConstructor
@Table(schema = "guest", name = "register_post")

public class Registration {
        @Id
        @GeneratedValue
        private long id;
        private long client_id;
        private long id_office;
        private LocalDate post_data;
        private Time post_time;

}
