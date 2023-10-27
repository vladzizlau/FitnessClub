package by.pvt.core.domain;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
//Стратегия 1
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Table(schema = "guest", name = "user")
//Стратегия 2
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
//Стратегия 3
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(schema = "guest", name = "user")


public class User
    {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "sur_name")
    private String surName;
    private Integer age;
    //    @Column(name = "phone_number", length = 50)
//    String phoneNumber;
//    @Column(name = "last_visit_date", length = 30)
//    LocalDate lastVisitDate;
//    String status;
    @Column(name = "amount_sum")
    private BigDecimal amountSum;
//    @Embedded
//    private Adress adress;

    @OneToMany(mappedBy = "user")
    private List<Posts> posts;
    }
