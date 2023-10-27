package by.pvt.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

// Сущность записи
@Data
@Entity
@NoArgsConstructor
@Table(schema = "guest", name = "register_post")

public class Registration {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private long id;
        private long client_id;
        private long id_office;
        private LocalDate post_data;
        private Time post_time;

}
