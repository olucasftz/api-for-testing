package br.com.dicasdeumdev.apitestes.resources.exceptions;

import br.com.dicasdeumdev.apitestes.services.exceptions.DataIntegrityViolationException;
import br.com.dicasdeumdev.apitestes.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ResourceExceptionHandlerTest {

    public static final String OBJECT_NOT_FOUND = "Object Not Found";
    public static final String EMAIL_ALREADY_REGISTERED = "email already registered";
    @InjectMocks
    private ResourceExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundReturnAnResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler.objectNotFound(
                new ObjectNotFoundException(OBJECT_NOT_FOUND),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(OBJECT_NOT_FOUND, response.getBody().getError());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(404, response.getBody().getStatus());
    }

    @Test
    void whenDataIntegrityViolationReturnAnResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler.dataIntegrityViolation(
                new DataIntegrityViolationException(EMAIL_ALREADY_REGISTERED),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(EMAIL_ALREADY_REGISTERED, response.getBody().getError());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(400, response.getBody().getStatus());
        assertNotEquals("/users/2", response.getBody().getPath());
        assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());
    }
}