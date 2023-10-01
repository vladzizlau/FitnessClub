package by.pvt.core.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Adress
    {

    private String city;
    private String street;
    private String homeNumber;
    private String postCode;  // почтовый индекс


    }
