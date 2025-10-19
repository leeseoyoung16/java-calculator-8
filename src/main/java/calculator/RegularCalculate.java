package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularCalculate {

    // 1개 이상의 특수 구분자 받을 경우 (ver.정규식 사용)
    public static void regularCalculate() {
        String input = Calculate.getInput();

        Matcher matcher = Pattern.compile("//(.)+\\\\n(.*)").matcher(input);
        String[] delimiters = {",",":"};
        String numbers = input;

        if(matcher.find()) { //커스텀 구분자
            String custom = matcher.group(1);
            delimiters = new String[]{custom};
            numbers = matcher.group(2);
        }

        if(!Calculate.isValidInput(numbers, delimiters)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        List<String> list = Calculate.splitBySeparator(numbers, delimiters);
        int sum = Calculate.addSum(list);
        Calculate.displayResult(sum);

    }
}
