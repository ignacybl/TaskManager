import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateValidatorTest {
    private DateValidator validator;
    @BeforeEach
    void setUp(){
        validator = new DateValidator();
    }
    @Test
    void shouldAcceptIfDateIsToday(){
        assertDoesNotThrow(() -> validator.validate(LocalDate.now()));
    }
    @Test
    void shouldAcceptIfDateIsInTheFuture(){
        assertDoesNotThrow(()->validator.validate(LocalDate.of(4030, 1, 1)));
    }
    @Test
    void shouldNotAcceptIfDateIsNull(){
        assertThrows(RuntimeException.class, () -> validator.validate(null));
    }
    @Test
    void shouldNotAcceptIfDateIsInThePast(){
        assertThrows(RuntimeException.class, () -> validator.validate(LocalDate.of(1000, 1, 1)));
    }

}