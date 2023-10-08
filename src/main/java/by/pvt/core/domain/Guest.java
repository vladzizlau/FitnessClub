package by.pvt.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "PK_guest_id")
public class Guest extends User {

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;
    @Column(name = "first_visit_date", length = 30)
    private LocalDate firstVisitDate;
    @Column(name = "last_visit_date", length = 30)
    private LocalDate lastVisitDate;
    private String status;
    @Column(name = "amount_sum")
    private BigDecimal amountSum;

    @OneToMany
    @JoinColumn(name = "visits_id")
    private List<Visits> visits;
}