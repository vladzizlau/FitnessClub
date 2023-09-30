package by.pvt.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Adress {

    String city;
    String street;
    String homeNumber;
    String postCode;  // почтовый индекс


}
