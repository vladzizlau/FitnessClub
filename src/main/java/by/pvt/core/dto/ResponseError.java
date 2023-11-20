package by.pvt.core.dto;

import lombok.Data;

@Data
public class ResponseError {
    private Integer statusCode;
    private String message;
}
