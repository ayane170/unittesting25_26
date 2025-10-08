package week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
PasswordValidator pv = new PasswordValidator();

    @Test
    void validate_lessThan8chars_returnsError() {
       assertEquals("Password must be at least 8 characters",pv.validate("aya","q2T#"));
    }
    @Test
    void validate_containsUsername_returnsError() {
        assertEquals("your password must not be same as the username",pv.validate("aya","qwerty2003aya##@@"));
    }
    @Test
    void validate_noNum_returnsError() {
        assertEquals("add a number",pv.validate("aya","qwertyTAZA##@@"));
    }
    @Test
    void validate_noLowerCase_returnsError() {
        assertEquals("add a lower letter",pv.validate("aya","2003TAZA##@@"));
    }
    @Test
    void validate_noCapital_returnsError() {
        assertEquals("add a capitale letter",pv.validate("aya","qwerty2003##@@"));
    }
    @Test
    void validate_noSymbol_returnsError() {
        assertEquals("add a symbool",pv.validate("aya","qwerty2003TAZA"));
    }

}