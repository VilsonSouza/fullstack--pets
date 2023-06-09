package br.com.treinaweb.adote_um_pet.api.common.handlers;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

import br.com.treinaweb.adote_um_pet.api.common.dtos.ErrorResponse;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final SnakeCaseStrategy snakeCaseStrategy = new SnakeCaseStrategy();
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException exception,
            HttpHeaders headers, 
            HttpStatus status, 
            WebRequest request
        ) {
        // TODO Auto-generated method stub
       var body= ErrorResponse.builder()
            .status(status.value())
            .error(status.getReasonPhrase())
            .cause(exception.getClass().getSimpleName())
            .message("Houveram erros de validação")
            .timestamp(LocalDateTime.now())
            .errors(convertFieldErrors(exception.getBindingResult().getFieldErrors()))
            .build();
        return new ResponseEntity<>(body, status);
    }

    private Map<String, List<String>> convertFieldErrors(List<FieldError> fieldErrors){
        var errors = new HashMap<String, List<String>>();
        fieldErrors.stream().forEach(fieldError -> {
            var field =  snakeCaseStrategy.translate(fieldError.getField());
            if(errors.containsKey(field)){
                errors.get(field).add(fieldError.getDefaultMessage());

            }else{
              
                errors.put(
                    field,
                    Stream.of(fieldError.getDefaultMessage()).collect(Collectors.toList())
                
                );
            }

        });


        return errors;
    }
}
