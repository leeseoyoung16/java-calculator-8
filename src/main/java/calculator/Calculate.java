package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    //1. 사용자 입력 처리
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        return input;
    }
    //2. 결과 출력
    public static void displayResult(int sum) {
        System.out.println("결과 : " + sum);
    }
    //3. 커스텀 구분자 판별
    public static boolean checkCustomSeparator(String input) {
        return (input.startsWith("//") && input.contains("\\n"));
    }
    //4. 구분자 선언부 제거
    public static String removeSeparator(String input) {
        int startIndex = -1;
        if (input.contains("\\n"))
            startIndex = input.indexOf("\\n")+2;
        return input.substring(startIndex);
    }
    //5. 커스텀 구분자 도출
    public static char getSeparator(String input) {
        return input.charAt(2);
    }
    //6. 식별자 문자인지 판별
    public static boolean isSeparator(char c, char[] separator) {
        for(char s : separator) {
            if(s == c) return true;
        }
        return false;
    }
    //7. 입력 유효성 검사 (숫자, 식별자에 포함되는 문자)
    public static boolean isValidInput(String input, char[] separator) {
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(!Character.isDigit(c)) {
                if(!isSeparator(c, separator)) return false;
            }
        }
        return true;
    }
    //8. 문자열 파싱
    public static ArrayList<String> splitBySeparator(String input, char[] separator) {
        ArrayList<String> list = new ArrayList<>();
        String splitInput = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isSeparator(c, separator)) {
                if (!splitInput.isEmpty()) list.add(splitInput);
                splitInput = "";
            } else {
                splitInput += c;
            }

            if (i == input.length() - 1 && !splitInput.isEmpty()) {
                list.add(splitInput);
            }
        }
        return list;
    }
    //9. 합계 계산
    public static int addSum(List<String> list) {
        int sum = 0;
        for(String c : list) {
            int convertInt = Integer.parseInt(c);
            sum += convertInt;
        }
        return sum;
    }

    public void run() {
        String input = getInput();
        char[] separator = new char[]{',',':'};
        String removeInput = input;

        if(checkCustomSeparator(input)) {
            char customSeparator = getSeparator(input);
            separator = new char[]{customSeparator};
            removeInput = removeSeparator(input);
        }

        if(!isValidInput(removeInput, separator)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        List<String> list = splitBySeparator(removeInput, separator);
        int sum = addSum(list);
        displayResult(sum);
    }
}
