package ch3;

public class Ex9 {
    public static void main(String[] args) {
        int a = 10, b = 4;

        System.out.printf("%d + %d = %d%n", a, b, a + b);
        System.out.printf("%d + %d = %d%n", a, b, a - b);
        System.out.printf("%d + %d = %d%n", a, b, a * b);
        System.out.printf("%d + %d = %d%n", a, b, a / b);   // 컴퓨터의 연산은 같은 타입으로만 연산 -> 2.5가 아닌 2로 추출
        System.out.printf("%d + %f = %f%n",a, (float)b, a / (float)b);

        System.out.println();

        int x = 1_000_000;      // 1,000,000  1백만
        int y = 2_000_000;      // 2,000,000  2백만

        long z = x * y;         // x*y = 2,000,000,000,000 ?
                                // x*y = -1454759936 : 오버플로우 발생
                                // int * int의 값의 계산 결과가 int의 범위를 이미 초과 -> 오버 플로우 발생
        System.out.println(z);

        System.out.println((long)(x * y));   // 이미 값이 오버플로우가 되었으므로 형변환해도 차이 없음
        System.out.println((long)x * y);     // x값을 long으로 형변환해서 결과값또한 long으로 추출
                                             // 자동 형변환
    }
}
