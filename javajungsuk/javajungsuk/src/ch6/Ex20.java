package ch6;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Method method = new Method();

        System.out.println("구구단 출력하기 (2단~9단)");
        System.out.println("원하는 단수를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        method.printGugudan(n);
    }
}

class Method{
    void printGugudan(int dan) {
        if (!(2 <= dan && dan <= 9)) {
            System.out.println("잘못된 입력값입니다.");
            return;     // 호출한 곳으로 돌려보냄
        }

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d%n", dan, i, dan * i);
        }
        // 반환 타입이 void이므로 생략 가능 -> 컴파일러가 자동 추가
    }
}
