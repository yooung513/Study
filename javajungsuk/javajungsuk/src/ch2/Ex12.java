package ch2;

public class Ex12 {
    public static void main(String[] args) {

        // println의 단점
        // 1. 실수의 자리수 조절 불가
        System.out.println(10.0/3);
//        System.out.println("%.2f", 10.0/3);     // 에러

        // 2. 10진수로만 출력
        System.out.println(0x1A);           // 26(10)
//        System.out.println("%d", 0x1A);     // 에러
//        System.out.println("%x", 0x1A);     // 에러

        System.out.println();
        System.out.println();


        // printf()로 출력형식 지정 가능
        System.out.printf("%.2f", 10.0/3);
        System.out.println();
        System.out.printf("%d%n", 0x1A);
        System.out.printf("%x\n", 0x1A);

        int year = 2023, month = 10;
        System.out.printf("지금은 %d년 %d월 입니다.", year, month);

        // 1. 정수를 10진수, 8진수, 16진수, 2진수로 출력
        System.out.printf("%d %n", 15);    // 10진수 15
        System.out.printf("%o %n", 15);    // 8진수 17
        System.out.printf("%x %n", 15);    // 16진수 f
        System.out.printf("%s %n", Integer.toBinaryString(15));    // 2진수 문자열로 변환 : 1111

        System.out.println();

        // 2. 8진수와 16진수의 접두사 표현
        System.out.printf("%#o %n", 15);   //017
        System.out.printf("%#x %n", 15);   //0xf   소문자 접두사
        System.out.printf("%#X %n", 15);   //0XF   대문자 접두사

        System.out.println();

        // 3. 실수 출력을 위한 지시자
        float f = 123.4567890f;
        System.out.printf("%f %n", f);     // 실수형식
        System.out.printf("%e %n", f);     // 지수형식
        System.out.printf("%g %n", f);     // 간략한 형식 - 실수/지수형식 중 간략한 형식으로 표현
        System.out.printf("%g %n", 0.00000001);

        double d = 123.456789;
        System.out.printf("%f %n", d);
        System.out.printf("%14.8f %n", d);

        System.out.println();

        // 4-1. 출력 자리 수 - 숫자형
        System.out.printf("%5d %n", 10);
        System.out.printf("%-5d %n", 10);       // 왼쪽 정렬
        System.out.printf("%05d %n", 10);       // 공백의 숫자를 0으로 치환 (0만 가능)
        System.out.printf("%5.3f %n", 10.0);    // 실수의 소수점 표현 : %전체자리.소수점아래자리f

        System.out.println();

        // 4-2. 출력 자리 수 - 문자형
        String name = "dayoungLee";
        System.out.printf("%s %n", name);
        System.out.printf("%15s %n", name);
        System.out.printf("%-15s %n", name);       // 왼쪽 정렬
        System.out.printf("%.7s %n", name);        // 부분 정렬
    }
}
