package ch2;

public class Ex6 {
    public static void main(String[] args) {
        int x = 10, y = 20;
        int tmp;

        tmp = x;    // 1. x의 값을 tmp에 저장
        x = y;      // 2. y의 값을 x에 저장
        y = tmp;    // 3. tmp의 값을 y에 저장

        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
