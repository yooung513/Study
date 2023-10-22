package ch3;

public class Ex11 {
    public static void main(String[] args) {

        // Ch3-11. 반올림 Math.round()
        double pi = 3.141592;
        double shortPi = Math.round(pi*1000)/1000.0;

        System.out.println(shortPi);
        System.out.println();


        // 연산 과정
        System.out.println(pi);                             // 3.141592
        System.out.println(pi*1000);                        // 3141.592
        System.out.println(Math.round(pi*1000));            // 3142
        System.out.println(Math.round(pi*1000)/1000.0);     // 3.142
        System.out.println(Math.round(pi*1000)/1000);       // 3
        System.out.println();


        // 반올림을 하지 않고 값을 얻으려면? -> 값 손실 유도
        System.out.println((int)(pi*1000));
        System.out.println((int)(pi*1000)/1000.0);
        System.out.println();



        // Ch3-12. 나머지 연산자
        int x = 10, y = 8;

        System.out.printf("%d을 %d로 나누면? %n", x, y);
        System.out.printf("몫은 %d이고, 나머지는 %d입니다. %n", x/y, x%y);
        System.out.println();
        System.out.printf("%d을 %d로 나누면? %n", x, -y);
        System.out.printf("몫은 %d이고, 나머지는 %d입니다. %n", x/-y, x%-y);   // 나머지 연산자의 경우 부호는 무시
    }
}
