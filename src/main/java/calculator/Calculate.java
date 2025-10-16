package calculator;

import java.util.Scanner;

public class Calculate {
    //1. 사용자 입력 처리
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String input =  sc.nextLine();
        return input;
    }
    //2. 결과 출력
    public static void displayResult(int sum) {
        System.out.println("결과: " + sum);
    }
    //3. 특수 구분자 판별
    public static boolean checkCustomSeparator(String input) {
        return (input.startsWith("//") && input.contains("\n"));
    }
    //4. 구분자 선언부 제거
    public static String removeSeparator(String input) {
        String splitInput;
        String removeInput = input.substring(4);
        return removeInput;
    }
}
