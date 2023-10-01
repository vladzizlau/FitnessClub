package by.pvt.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Table(schema = "guest", name = "visits")
@Data
@Entity
public class Visits
    {
    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private LocalDate lastVisit;
    private double amountSum;
    private long id_Offer;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "guest_id")
    private Guest guest;
    }
