package by.pvt.core.domain;
//Скидки (sales)



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Setter
@Getter
@Table(schema = "guest", name = "discount")

public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private BigDecimal discount_value;
    private LocalDate discount_start;
    private LocalDate discount_stop;
    private String client_status;
}
