package by.pvt.core.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data

public class ClientRequest {
    private long id;
    private String firstName;

    private String surName;
    private Integer age;

    private String phoneNumber;
    private String status;

    private BigDecimal amountSum;

    private LocalDate firstVisitDate;

    private LocalDate lastVisitDate;

}
