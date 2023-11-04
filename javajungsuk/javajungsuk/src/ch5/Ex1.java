package ch5;

public class Ex1 {
    public static void main(String[] args) {
//        int[] score;            // 1. 배열 score를 선언 (참조변수 선언)
//        score = new int[5];     // 2. 배열의 생성 (int 저장공간*5)

        int[] score = new int[5];   // 1-2. 동시에 배열의 선언과 생성
        score[3] = 100;

        System.out.println("score[0]="+score[0]);   // int 배열에 아무것도 할당하지 않은 경우, 0
        System.out.println("score[1]="+score[1]);
        System.out.println("score[2]="+score[2]);
        System.out.println("score[3]="+score[3]);
        System.out.println("score[4]="+score[4]);

        int value = score[3];
        System.out.println("value="+value);


        String[] name = new String[5];
        name[3] = "dayoung";

        System.out.println("name[0]="+name[0]);     // string 배열에 아무것도 할당하지 않은 경우, null
        System.out.println("name[1]="+name[1]);
        System.out.println("name[2]="+name[2]);
        System.out.println("name[3]="+name[3]);
        System.out.println("name[4]="+name[4]); 
    }
}
