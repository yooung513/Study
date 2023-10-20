package ch3;

public class Ex5 {
    public static void main(String[] args) {
        int i = 5, j = 0;

        j = i++;    // 후위형
        System.out.println("j=i++; 실행 후, i = " + i + ", j = " + j);

        // i와 j값 리셋
        i=5;
        j=0;

        j = ++i;    // 전위형
        System.out.println("j=++i; 실행 후, i = " + i + ", j = " + j);

        int a = 3, b = -5;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("-a = " + -a + ", -b = " + -b);
    }
}
