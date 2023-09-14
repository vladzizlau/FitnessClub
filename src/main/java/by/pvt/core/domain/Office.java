package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

//Помещения
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "guest", name = "office")
public class Office {
    // Id, наименование помещения, идентификационный номер,  максимальное количество человек, статус (Активен, на ремонте), стоимость за 1 ч.

    @Id
    @GeneratedValue
    @Column(name = "ID")
    Long id;
    @Column(name = "name_room")
    String nameRoom;
    @Column(name = "id_room")
    long roomID; //Инвентарный номер помещения
    @Column(name = "max_count_people")
    int maxCountPeople;
    @Column(name = "office_status")
    String statusOffice;
    @Column(name = "cost_per_one_hour")
    BigDecimal cost_per_hour;

    public Office(String nameRoom, long roomID, int maxCountPeople, StatusOffice statusOffice, BigDecimal cost_per_hour) {

        this.nameRoom = nameRoom;
        this.roomID = roomID;
        this.maxCountPeople = maxCountPeople;
        this.statusOffice = String.valueOf(statusOffice);
        this.cost_per_hour = cost_per_hour;
    }


}
