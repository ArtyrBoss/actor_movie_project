package ru.valder.spring.actor_movie.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus httpStatus;
    protected String reason;
    protected String messageForClient;
    protected String messageForDeveloper;
    protected Map<?, ?> responseData;

}

