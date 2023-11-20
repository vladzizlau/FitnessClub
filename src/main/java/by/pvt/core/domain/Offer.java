package by.pvt.core.domain;
//Услуги (или по другому Сервис)

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;
import java.util.List;

//Услуги и предложения
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(schema = "guest", name = "offer")
public class Offer
    {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
