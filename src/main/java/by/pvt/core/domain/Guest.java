package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table (schema = "guest", name = "guest")
@PrimaryKeyJoinColumn (name = "PK_guest_id")
public class Guest extends User{

    @Column(name = "phone_number", length = 50)
    String phoneNumber;
    @Column(name = "first_visit_date", length = 30)
    LocalDate firstVisitDate;
    @Column(name = "last_visit_date", length = 30)
    LocalDate lastVisitDate;
    String status;
    @Column(name = "amount_sum")
    BigDecimal amountSum;

    @OneToMany
    @JoinColumn(name = "visits_id")
    private List<Visits> visits;
}