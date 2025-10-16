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
}
