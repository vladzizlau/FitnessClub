package by.pvt.core.domain;

import lombok.*;

import jakarta.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Entity
@RequiredArgsConstructor
@Table(schema = "guest", name = "post")
public class Posts
    {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long client_id;
    private long id_office;
    private LocalDate post_data;
    private Time post_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "post_client_id")
    private Client client;


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "post_office_id")
    private Office office;


    }
