package by.pvt.core.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiscountRequest {
    @NotBlank
    @Column(length = 100)
    private String name;
    @NotNull
    @Positive(message = "Вы ввели отрицательное число")
    private BigDecimal discount_value;
    @NotNull
    private LocalDate discount_start;
    @NotNull
    private LocalDate discount_stop;
    @NotBlank
    private String client_status;

    @AssertTrue
    private boolean istof(){
        return discount_start.isBefore(discount_stop);
    }



}
