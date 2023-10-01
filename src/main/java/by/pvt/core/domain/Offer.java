package by.pvt.core.domain;
//Услуги (или по другому Сервис)

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//Услуги и предложения
@Data
@Entity
@Table(schema = "guest", name = "offer")
public class Offer
    {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name = "name_service")
    private String nameService;
    @Column(name = "price")
    private double price;

    public Offer(String nameService, double price)
        {
        this.nameService = nameService;
        this.price = price;
        }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_id")
    private List<Office> office;


    }
