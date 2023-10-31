package ch4;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {

        // 예제 1
        int i = 5;  // 반복할 횟수

        while (i-- != 0) {
            System.out.println(i + " - I can do it.");
        }
        System.out.println();


        // 예제 2 - 누적합이 100을 넘지 않는 최대값 구하기
        int sum = 0;
        int x = 0;

        while (sum <= 100) {
            System.out.printf("%d - %d%n", x, sum);
            sum += ++x;
        }
        System.out.println();


        // 예제 3. 각 자리수의 합
        int num = 0;
        int ans = 0;
        System.out.print("숫자를 입력하세요. (예: 12345)");

        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        num = Integer.parseInt(tmp);

        while (num != 0) {
            // num을 10으로 나눈 나머지를 ans에 더함
            ans += num % 10;    // sum = sum + num%10
            System.out.printf("ans = %3d, num = %3d %n", ans, num);
            num /= 10;
        }
        System.out.println("각 자리수의 합 : " + ans);

    }
}
