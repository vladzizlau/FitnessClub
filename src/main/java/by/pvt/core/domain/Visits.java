package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(schema = "guest", name = "visits")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    }
