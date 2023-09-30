package by.pvt.core.domain;
//Услуги (или по другому Сервис)

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//Услуги и предложения
@Data
@Entity
@Table(schema = "guest", name = "offer")
public class Offer {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    long id;
    @Column(name = "name_service")
    String nameService;
    @Column(name = "price")
    double price;

    public Offer(String nameService, double price) {
        this.nameService = nameService;
        this.price = price;
    }
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_id")
    private List<Office> office;



}
