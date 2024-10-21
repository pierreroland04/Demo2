package heh.be.demo.exception_handler;

import heh.be.demo.vue.ConstraintViolations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// ctrl alt O pour suppr les lignes non utiles dans les imports
// ctrl alt l pour tout indenter

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice("heh.be.demo")
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        //log.info("handleMethodArgumentNotValidException"+exception.getMessage());
        ProblemDetail validationProblemDetail =
                ProblemDetail.forStatusAndDetail(BAD_REQUEST, "Validation error");

        List<ConstraintViolations> errors = exception.getFieldErrors()
                .stream()
                .map(violation -> ConstraintViolations.builder()
                        .message(violation.getDefaultMessage())
                        .fieldName(violation.getField())
                        .rejectedValue(Objects.isNull(
                                violation.getRejectedValue()) ?
                                "null" :
                                violation.getRejectedValue().toString())
                        .build())
                .collect(Collectors.toList());

        validationProblemDetail.setProperty("errors", errors);
        //log.info("handleMethodArgumentNotValidException"+validationProblemDetail);
        return validationProblemDetail;
    }
}
