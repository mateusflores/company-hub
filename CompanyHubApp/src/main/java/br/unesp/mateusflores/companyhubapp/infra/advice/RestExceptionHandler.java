package br.unesp.mateusflores.companyhubapp.infra.advice;

import br.unesp.mateusflores.companyhubapp.exceptions.ApiErrorDTO;
import br.unesp.mateusflores.companyhubapp.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        log.warn("Recurso não encontrado: '{}' no caminho '{}'",
                e.getMessage(), request.getRequestURI());

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiErrorDTO errorDTO = new ApiErrorDTO(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(errorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.warn("Argumento(s) inválido(s): '{}' no caminho '{}'", e.getMessage(), request.getRequestURI());

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiErrorDTO errorDTO = new ApiErrorDTO(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(errorDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGenericException(Exception ex, HttpServletRequest request) {
        log.error("Erro inesperado e não tratado no servidor para o caminho '{}'", request.getRequestURI(), ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiErrorDTO errorDTO = new ApiErrorDTO(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                "Ocorreu um erro inesperado no servidor.",
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(errorDTO);
    }

}
