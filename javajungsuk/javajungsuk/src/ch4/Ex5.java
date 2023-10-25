package ch4;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        int score = 0;                  // 점수 저장 변수
        char grade = ' ', opt = ' ';    // 학점 저장 변수 (공백으로 초기화)


        System.out.print("점수를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        score = sc.nextInt();   // 화면을 통해 입력받은 숫자를 score에 저장

        System.out.printf("당신의 점수는 %d입니다. %n", score);

        if (score >= 90) {
            grade = 'A';
            if (score >= 98) {
                opt = '+';
            } else if (score < 94) {
                opt = '-';
            }
        } else if (score >= 80) {
            grade = 'B';
            if (score >= 88) {
                opt = '+';
            } else if (score < 84) {
                opt = '-';
            }
        } else if (score >= 70) {
            grade = 'C';
            if (score >= 78) {
                opt = '+';
            } else if (score < 74) {
                opt = '-';
            }
        } else {
            grade = 'D';
        }

        System.out.println("당신의 학점은 " + grade + opt + "입니다.");
    }
}
