package ch5;

public class Ex4 {
    public static void main(String[] args) {
        // 5-4. 배열의 길이
        // 인덱스의 범위 : 0 ~ 5
        int[] arr = new int[5];     // 길이가 5인 int배열 arr을 생성
        System.out.println("arr.length="+arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"]="+arr[i]);
        }

        // 배열의 크기를 변경한 후 for문의 범위를 같이 변경하지 않은 경우
        // ArrayIndexOutOfBoundsException 에러 발생



        // 5-5. 배열의 초기화
        // 방법 1
        int[] score_1 = new int[5];
        score_1[0] = 50;
        score_1[1] = 60;
        score_1[2] = 70;
        score_1[3] = 80;
        score_1[4] = 90;

        // 방법 2
        int[] score_2 = new int[5];
        for (int i = 0; i < score_2.length; i++) {
            score_2[i] = i * 10 + 50;
        }

        // 방법 3
        int[] score_3 = new int[]{50, 60, 70, 80, 90};

        // 방법 4
        int[] score_4 = {50, 60, 70, 80, 90};   // new int[]를 생략할 수 있음
        // 단, 선언과 초기화를 나눠서 할수는 없음
//        int[] score_5;
//        score_5 = {50, 60, 70, 80, 90};         // 에러 -> new int[]를 생략할 수 없음

    }
}
