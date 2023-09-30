package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Table(schema = "guest", name = "user")
@Where(clause = "status = 'Premium'")
@Data
@Entity
public class PremiumUser {
    @Id
    @SequenceGenerator(name = "seq_User", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_User")
    long id;
    @Column(name = "first_name", length = 50)
    String firstName;
    @Column(name = "sur_name")
    String surName;
    Integer age;
    @Column(name = "phone_number", length = 50)
    String phoneNumber;
    @Column(name = "last_visit_date", length = 30)
    LocalDate lastVisitDate;
    String status;
    @Column(name = "amount_sum")
    BigDecimal amountSum;
    @Embedded
    private Adress adress;
}
