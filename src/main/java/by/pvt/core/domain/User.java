package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "guest", name = "user")
public class User {
    @Id
    long id;
    String firstName;
    String surName;
    Integer age;
    @Column (name = "phone_number")
    String phoneNumber;
    @Column (name = "last_visit_date")
    LocalDate lastVisitDate;
    @Enumerated (EnumType.STRING)
    Status status;
    @Column (name = "amount_sum")
    BigDecimal amountSum;
}
