package by.pvt.core.domain;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(schema = "guest", name = "visits")
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate lastVisit;
    private double amountSum;
    private long id_Offer;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "client_id")
    private Client client;

}
