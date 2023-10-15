package by.pvt.core.domain;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

//Помещения
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache (usage = CacheConcurrencyStrategy.READ_WRITE, region = "office")
@Table(schema = "guest", name = "office")
public class Office
    {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "name_room")
    private String nameRoom;
    @Column(name = "id_room")
    private long roomID; //Инвентарный номер помещения
    @Column(name = "max_count_people")
    private int maxCountPeople;
    @Column(name = "office_status")
    private String statusOffice;
    @Column(name = "cost_per_one_hour")
    private BigDecimal cost_per_hour;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "office_id_offer")
    private Offer offer;

//    @OneToMany(mappedBy = "office", cascade = CascadeType.REMOVE)
//    private List<Posts> posts;

    public Office(String nameRoom, long roomID, int maxCountPeople, StatusOffice statusOffice, BigDecimal cost_per_hour)
        {

        this.nameRoom = nameRoom;
        this.roomID = roomID;
        this.maxCountPeople = maxCountPeople;
        this.statusOffice = String.valueOf(statusOffice);
        this.cost_per_hour = cost_per_hour;
        }


    }
