package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {
    //3. 특수 구분자 판별
    @Test
    void checkCustomSeparatorTest() {
        //given
        String normal = "12:3,4";
        String custom = "//;\n12;3;4";
        //when
        boolean normalResult = Calculate.checkCustomSeparator(normal);
        boolean customResult = Calculate.checkCustomSeparator(custom);
        //then
        assertFalse(normalResult);
        assertTrue(customResult);
    }

    //4. 구분자 선언부 제거
    @Test
    void removeSeparatorTest() {
        //given
        String custom = "//;\n12;3;4";
        //when
        String splitCustomSeparator = Calculate.removeSeparator(custom);
        //then
        assertEquals("12;3;4",  splitCustomSeparator);
    }
    //5. 특수 구분자 도출
    @Test
    void getSeparatorTest() {
        //given
        String custom = "//;\n12;3;4";
        //when
        char separator = Calculate.getSeparator(custom);
        //then
        assertEquals(';', separator);
    }
    //식별자인지 판별
    @Test
    void isValidCharacterTest() {
        //given
        char normal = ',';
        char custom = ';';
        char error = '?';
        char[] normalSeparator = new char[] {',',':'};
        char[] customSeparator = new char[] {';'};
        //when
        boolean normalCase = Calculate.isSeparator(normal, normalSeparator);
        boolean customCase = Calculate.isSeparator(custom, customSeparator);
        boolean errorCase = Calculate.isSeparator(error, normalSeparator);
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
        //when
        boolean normalCase = Calculate.isValidInput(normal, normalSeparator);
        boolean customCase = Calculate.isValidInput(custom,  customSeparator);
        boolean errorCase = Calculate.isValidInput(error, normalSeparator);
        //then
        assertTrue(normalCase);
        assertTrue(customCase);
        assertFalse(errorCase);
    }
    //7. 문자열 파싱
    @Test
    void splitBySeparatorTest() {
        //given
        String input = "12:3,4";
        char[] separator = new char[] {',',':'};

        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("12");
        expectedResult.add("3");
        expectedResult.add("4");
        //when
        ArrayList<String> result = Calculate.splitBySeparator(input, separator);
        //then
        assertEquals(expectedResult, result);
    }
    //8. 합계 계산
    @Test
    void addSumTest() {
        //given
        ArrayList<String> list = new ArrayList<>();
        list.add("12");
        list.add("3");
        list.add("4");
        //when
        int sum = Calculate.addSum(list);
        //then
        assertEquals(19,sum);
    }
}
