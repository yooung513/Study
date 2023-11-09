package ch5;

import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {

        // 예제 1
        int[][] score = {       // 정사각형이 아닌 각각의 행마다 길이가 달라도 가능
                {100, 100, 100, 100},
                {20, 20, 20},
                {30},
                {40, 40}
        };
        int sum = 0;

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.printf("score[%d][%d]=%d%n", i, j, score[i][j]);

                sum += score[i][j];
            }
        }
        System.out.println("sum = " + sum);
        System.out.println();


        // 예제 2
        int[][] score_ = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40},
                {50, 50, 50}
        };

        int korTotal = 0, engTotal = 0, mathTotal = 0;
        System.out.println(" 번호  국어  영어  수학  총점  평균");
        System.out.println("=============================");

        for (int i = 0; i < score_.length; i++) {
            int sum_ = 0;
            float avg = 0.0f;

            korTotal += score_[i][0];
            engTotal += score_[i][1];
            mathTotal += score_[i][2];
            System.out.printf("%3d", i+1);

            for (int j = 0; j < score_[i].length; j++) {
                sum_ += score_[i][j];
                System.out.printf("%5d", score_[i][j]);
            }
            avg = sum_ / (float) (score_[i].length);

            System.out.printf("%5d %5.1f %n", sum_, avg);
        }
        System.out.println("=============================");
        System.out.printf("총점 : %3d %4d %4d %n%n", korTotal, engTotal, mathTotal);


        // 예제 3
        String[][] words = {
                {"chair", "의자"},
                {"computer", "컴퓨터"},
                {"integer", "정수"}
        };

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);

            String tmp = sc.nextLine();
            tmp = tmp.replaceAll(" ", "");  // 공백 제거

            if (tmp.equals(words[i][1])) {
                System.out.printf("정답입니다. %n%n");
            } else {
                System.out.printf("오답입니다. %n%n");
            }
        }

    }
}
