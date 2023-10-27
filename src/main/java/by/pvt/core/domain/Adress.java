package by.pvt.core.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;

@Embeddable
@Data

public class Adress
    {

    private String city;
    private String street;
    private String homeNumber;
    private String postCode;  // почтовый индекс


    }
