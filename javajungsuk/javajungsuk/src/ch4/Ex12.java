package ch4;

public class Ex12 {
    public static void main(String[] args) {
        int num = 0;

        for (int i = 1; i <= 5; i++){
            System.out.println(Math.random());  // 0.0 <= x < 1.0
        }
        System.out.println();


        System.out.println("Quiz 1번");
        // Q1. 1~10 사이의 난수를 20개 출력하세요.
        for (int i = 1; i <= 20; i++){
            System.out.println( (int)(Math.random()*10)+1 );
        }
        System.out.println();


        System.out.println("Quiz 2번");
        // Q2. -5~5 사이의 난수를 20개 출력하세요.
        for (int i = 1; i <= 20; i++) {
            // -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 => 11개
            System.out.println( (int)(Math.random()*11)-5 );
        }
    }
}
