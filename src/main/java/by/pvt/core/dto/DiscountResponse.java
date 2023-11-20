package by.pvt.core.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class DiscountResponse {
    private long id;
    private String name;
    private BigDecimal discount_value;
    private LocalDate discount_start;
    private LocalDate discount_stop;
    private String client_status;
}
