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
    //5. 특수 구분자 도출
    @Test
    void getSeparatorTest() {
        //given
        String custom = "//;\n12;3;4";
        Calculate cal = new Calculate();
        //when
        char separator = cal.getSeparator(custom);
        //then
        assertEquals(';', separator);
    }
    //식별자 외 문자인지 판별
    @Test
    void isValidCharacterTest() {
        //given
        char normal = ',';
        char custom = ';';
        char error = '?';
        char[] normalSeparator = new char[] {',',':'};
        char[] customSeparator = new char[] {';'};
        Calculate cal = new Calculate();
        //when
        boolean normalCase = cal.isVaildCharacter(normal, normalSeparator);
        boolean customCase = cal.isVaildCharacter(custom, customSeparator);
        boolean errorCase = cal.isVaildCharacter(error, normalSeparator);
        //then[
        assertTrue(normalCase);
        assertTrue(customCase);
        assertFalse(errorCase);
    }
    //6. 입력 유효성 검사 (숫자, 식별자에 포함되는 문자)
    @Test
    void isValidInput() {
        //given
        String normal = "12:3,4";
        String custom = "12;3;4";
        String error = "12?4/5";
        char[] normalSeparator = new char[] {',',':'};
        char[] customSeparator = new char[] {';'};
        Calculate cal = new Calculate();
        //when
        boolean normalCase = cal.isValidInput(normal, normalSeparator);
        boolean customCase = cal.isValidInput(custom,  customSeparator);
        boolean errorCase = cal.isValidInput(error, normalSeparator);
        //then
        assertTrue(normalCase);
        assertTrue(customCase);
        assertFalse(errorCase);
    }
}
