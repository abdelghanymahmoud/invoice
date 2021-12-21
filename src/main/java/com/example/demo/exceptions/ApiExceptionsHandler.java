package com.example.demo.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class ApiExceptionsHandler {

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<?> handleApiExceptions(ResponseStatusException ex) {
    return new ResponseEntity<>(ex.getReason(), ex.getStatus());
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<?> handleMissingServletRequestParameterException(
      MissingServletRequestParameterException ex) {
    log.warn(ex.getMessage());
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> handleConstraintViolationException(
      ConstraintViolationException ex) {
    log.warn(ex.getMessage());
    String str = ex.getConstraintViolations().stream().map((cv) -> {
      return cv == null ? "null" : cv.getMessage();
    }).collect(Collectors.joining(", "));
    return new ResponseEntity<>(str, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    log.warn(ex.getMessage());
    List<String> errorList = ex.getBindingResult().getFieldErrors().stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
    return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
  }
}
