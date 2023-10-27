package by.pvt.core.domain;

import lombok.Data;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Table(schema = "guest", name = "user")
@Where(clause = "status = 'Premium'")
@Data
@Entity
public class PremiumUser
    {
    @Id
    @SequenceGenerator(name = "seq_User", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_User")
    private long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "sur_name")
    private String surName;
    private Integer age;
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;
    @Column(name = "last_visit_date", length = 30)
    private LocalDate lastVisitDate;
    private String status;
    @Column(name = "amount_sum")
    private BigDecimal amountSum;
    @Embedded
    private Adress adress;
    }
