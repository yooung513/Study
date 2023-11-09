package ch5;

public class Ex8 {
    public static void main(String[] args) {

        // 총합과 평균
        int sum = 0;
        float average = 0f;

        int[] score_1 = {100, 88, 100, 100, 90};

        for (int i = 0; i < score_1.length; i++) {
            sum += score_1[i];
        }
        average = sum / (float) score_1.length;   // 계산결과를 float 타입으로 얻으려 형변환

        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + average);
        System.out.println();



        // 최대값과 최소값
        int[] score_2 = {79, 88, 91, 33, 100, 55, 95};

        int max = score_2[0];
        int min = score_2[0];

        for (int i = 1; i < score_2.length; i++) {
            if (score_2[i] > max) {
                max = score_2[i];
            } else if (score_2[i] < min) {
                min = score_2[i];
            }
        }

        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);
    }
}
