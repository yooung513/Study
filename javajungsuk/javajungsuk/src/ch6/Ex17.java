package ch6;

public class Ex17 {
    public static void main(String[] args) {

        MyMath mm = new MyMath();

        long result1 = mm.add(5L, 3L);
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);
        long result5 = mm.max(5L, 3L);

        System.out.println("add(5L, 3L) = " + result1);
        System.out.println("subtract(5L, 3L) = " + result2);
        System.out.println("multiply(5L, 3L) = " + result3);
        System.out.println("divide(5L, 3L) = " + result4);
        System.out.println("두 값 중 더 큰 값은 " + result5 + "입니다.");

    }
}

class MyMath {
    long add(long a, long b) {
        return a + b;
    }

    long subtract(long a, long b) {
        return a - b;
    }

    long multiply(long a, long b) {
        return a * b;
    }

    double divide(double a, double b) {
        return a / b;
    }

    // 두 값을 받아서 큰 값을 반환하는 메소드를 작성하시오.
    long max(long a, long b) {
//        if (a > b) {
//            return a;
//        } else {
//            return b;
//        }
        return a > b ? a : b;
    }

}
