package ch5;

import java.util.Arrays;

public class Ex10 {
    public static void main(String[] args) {

        // 섞기
        int[] numArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(numArr));

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10);     // 0~9 중의 한 값을 임의로 얻는다.

            // numArr[0]과 numArr[n]의 값을 서로 바꾼다.
            int tmp = numArr[0];
            numArr[0] = numArr[n];
            numArr[n] = tmp;
        }

        System.out.println(Arrays.toString(numArr));
        System.out.println();


        // 로또 번호 만들기
        int[] ball = new int[45];   // 45개의 정수값을 저장하기

        for (int i = 0; i < ball.length; i++) {
            ball[i] = i + 1;        // 배열의 각 요소에 1~45의 값을 저장한다.
        }

        int tmp = 0;
        int j = 0;

        for (int i = 0; i < 6; i++) {
            j = (int) (Math.random() * 45);     // 0~44 범위의 임의의 정수를 추출한다.
            tmp = ball[i];
            ball[i] = ball[j];
            ball[j] = tmp;
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("ball[%d] = %d%n", i, ball[i]);
        }
    }
}
