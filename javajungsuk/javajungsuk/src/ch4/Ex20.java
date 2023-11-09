package ch4;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {

        // break문
        int sum = 0;
        int i = 0;

        while(true){    // 무한 반복문
            if(sum > 100){
                break;
            }
            ++i;
            sum += i;
        }

        System.out.println("i = " + i);
        System.out.println("sum = " + sum);
        System.out.println();


        // continue문
        for (int j=0; j<=10; j++){
            if (j%3 == 0){
                continue;
            }
            System.out.println(j);
        }
        System.out.println();


        // 이름붙은 반복문
        Loop1 : for (int x = 2; x <= 9; x++) {
            for (int y = 1; y <= 9; y++) {
                if (y == 5) {
                    break Loop1;
//                    break;
//                    continue Loop1;
//                    continue;
                }
                System.out.println(x+"*"+y+"="+ x*y);
            }
            System.out.println();
        }



        // 전체 활용 예제
        int menu = 0;
        int num = 0;

        Scanner sc = new Scanner(System.in);

        outer:  // while문의 이름 - outer
        while (true) {
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");
            System.out.println("원하는 메뉴(1~3)를 선택하세요. (종료 : 0)");

            String tmp = sc.nextLine();
            menu = Integer.parseInt(tmp);

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (!(1 <= menu && menu <= 3)) {
                System.out.println("메뉴를 잘못 선택하셨습니다. (종료 : 0)");
                continue;
            }
            System.out.println("선택하신 메뉴는 "+ menu + "번 입니다.");
            System.out.println();

            for (; ; ) {    // 무한 반복문
                System.out.println("계산할 값을 입력하세요. (계산 종료 : 0, 전체 종료 : 99)");
                tmp = sc.nextLine();
                num = Integer.parseInt(tmp);

                if (num == 0)
                    break;          // for문 종료

                if (num == 99)
                    break outer;    // 전체 종료 - while문 종료

                switch (menu) {
                    case 1:
                        System.out.println("result = " + num * num);
                        break;
                    case 2:
                        System.out.println("result = " + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("result = " + Math.log(num));
                        break;
                }
            }
        }
    }
}
