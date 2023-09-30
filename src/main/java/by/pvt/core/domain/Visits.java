package by.pvt.core.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(schema = "guest", name = "visits")
@Data
@Entity
public class Visits
    {
    @Id
    @GeneratedValue
    long id;
    long userId;
    LocalDate lastVisit;
    double amountSum;
    long id_Offer;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "guest_id")
    private Guest guest;
    }
