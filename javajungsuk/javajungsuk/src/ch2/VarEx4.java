package ch2;

public class VarEx4 {
    public static void main(String[] args) {
        boolean power = true;
//        boolean power = 0; // incompatible types: int cannot be converted to boolean : 타입이 맞지 않음
        System.out.println(power);

//        byte b = 128; // incompatible types: possible lossy conversion from int to byte : 범위 초과

        int oct = 010;  // 8진수, 10진수로 8
        int hex = 0x10; // 16진수, 10진수로 16
        System.out.println(oct);    // println는 10진수로 출력
        System.out.println(hex);    // 진법 그대로 출력하기 위해서 printf 사용

        long l1 = 1000_000_000;      // 10억의 경우 int 범위 안에 들기 때문에 접미사 생략 가능
//        long l2 = 20_000_000_000;    // 에러 integer number too large : 100억의 경우 int 범위를 초과하기 때문에 접미사 필수
        long l3 = 20_000_000_000L;
        System.out.println(l3);

        float f1 = 3.14f;
//        float f2 = 3.14;    // 에러 incompatible types: possible lossy conversion from double to float
        double d1 = 3.14;
        double d2 = 3.14f;      // double > float 가능
        System.out.println(f1);
        System.out.println(d1);
        System.out.println(d2);

        System.out.println(10.);
        System.out.println(.10);
        System.out.println(10f);
        System.out.println(1e3);
    }
}
