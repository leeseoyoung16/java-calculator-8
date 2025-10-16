package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculateTest {
    //3. 특수 구분자 판별
    @Test
    void isCustomSeparator() {
        //given
        String normal = "12:3,4";
        String custom = "//;\n12;3;4";
        Calculate cal = new Calculate();

        //when
        boolean normalResult = cal.checkCustomSeparator(normal);
        boolean customResult = cal.checkCustomSeparator(custom);

        //then
        assertFalse(normalResult);
        assertTrue(customResult);
    }
}
