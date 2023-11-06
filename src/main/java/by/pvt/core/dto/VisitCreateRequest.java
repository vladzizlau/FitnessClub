package by.pvt.core.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class VisitCreateRequest {
//    @NotBlank
//    private long id;
    @NotBlank
    private LocalDate lastVisit;
    @NotBlank
    private double amountSum;
    @NotBlank
    private long id_Offer;
}
