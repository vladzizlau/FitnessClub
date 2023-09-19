package by.pvt.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
//Стратегия 1
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(schema = "guest", name = "user")
//Стратегия 2
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
//Стратегия 3
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@Table(schema = "guest", name = "user")

public class User
    {
    @Id
//    @SequenceGenerator(name = "seq_User", sequenceName = "user_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_User")
    @GeneratedValue
    long id;
    @Column(name = "first_name", length = 50)
    String firstName;
    @Column(name = "sur_name")
    String surName;
    Integer age;
    //    @Column(name = "phone_number", length = 50)
//    String phoneNumber;
//    @Column(name = "last_visit_date", length = 30)
//    LocalDate lastVisitDate;
//    String status;
    @Column(name = "amount_sum")
    BigDecimal amountSum;
    @Embedded
    private Adress adress;
    }
