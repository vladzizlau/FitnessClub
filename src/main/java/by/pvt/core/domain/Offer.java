package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Услуги и предложения
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
