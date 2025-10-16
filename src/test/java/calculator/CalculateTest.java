package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {
    //3. 특수 구분자 판별
    @Test
    void checkCustomSeparatorTest() {
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

    //4. 구분자 선언부 제거
    @Test
    void removeSeparatorTest() {
        //given
        String custom = "//;\n12;3;4";
        Calculate cal = new Calculate();
        //when
        String splitCustomSeparator = cal.removeSeparator(custom);
        //then
        assertEquals("12;3;4",  splitCustomSeparator);
    }
}
