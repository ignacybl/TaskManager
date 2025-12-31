import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFieldValidatorTest {
    private TextFieldValidator validator;

    @BeforeEach
    void setUp(){
        validator = new TextFieldValidator();
    }

    @Test
    void shouldAcceptInput(){
        assertDoesNotThrow(() -> validator.validate("Input"));
    }
    @Test
    void shouldNotAcceptInputWhenNull(){
        assertThrows(RuntimeException.class, () -> validator.validate(null));
    }
    @Test
    void shouldNotAcceptWhenInputIsBlank(){
        assertThrows(RuntimeException.class, ()-> validator.validate(""));
    }
    @Test
    void shouldNotAcceptWhenInputIsTooLong(){
        assertThrows(RuntimeException.class, () -> validator.validate("i".repeat(201)) );
    }

}