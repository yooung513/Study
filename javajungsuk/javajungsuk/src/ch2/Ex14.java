package ch2;

// 1. import문 추가
import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {

        // 2. Scanner 클래스의 객체 생성
        Scanner sc1 = new Scanner(System.in);

        int num1 = sc1.nextInt();
        int num2 = sc1.nextInt();
        System.out.println(num1);
        System.out.println(num2);

        Scanner sc2 = new Scanner(System.in);
        String str = sc2.nextLine();
        int n = Integer.parseInt(str);      // 숫자로 변환 못하면 에러 발생
        System.out.println(n);
    }
}
