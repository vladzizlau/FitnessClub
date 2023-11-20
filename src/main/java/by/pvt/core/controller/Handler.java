package by.pvt.core.controller;

import by.pvt.core.dto.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class Handler {
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseError errr(MethodArgumentNotValidException e){
        ResponseError responseError = new ResponseError();
        responseError.setMessage(e.getMessage());
        responseError.setStatusCode(400);
        log.error("Exeption", e);
        return responseError;
    }

}
