package contact.arturneto.courses.springboot.handler;

import contact.arturneto.courses.springboot.error.ResourceNotFoundError;
import contact.arturneto.courses.springboot.error.ResourceNotFoundException;
import contact.arturneto.courses.springboot.error.StanderError;
import contact.arturneto.courses.springboot.error.ValidationError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundError> handlerResourceNotFoundException(ResourceNotFoundException exception) {
        ResourceNotFoundError error = ResourceNotFoundError.Builder.builder()
                .timestamp(System.currentTimeMillis())
                .title("Resource not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .classPath(exception.getClass().getName())
                .build();
        return new ResponseEntity<ResourceNotFoundError>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String messages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        ValidationError error = ValidationError.Builder.builder()
                .timestamp(System.currentTimeMillis())
                .title("Validation Error")
                .status(status.value())
                .message("Field Validation Error")
                .field(fields)
                .fieldMessage(messages)
                .classPath(exception.getClass().getName())
                .build();
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StanderError error = StanderError.Builder.builder()
                .timestamp(System.currentTimeMillis())
                .title("Internal Exception")
                .status(status.value())
                .message(ex.getMessage())
                .classPath(ex.getClass().getName())
                .build();

        return new ResponseEntity(error, headers, status);
    }
}
