package ch4;

public class Ex13 {
    public static void main(String[] args) {

        for (int i=1; i<=3; i++){
            System.out.println("Hello");
        }

        for (int i=10; i>=1; i--){
            System.out.println(i);
        }
        System.out.println();

        for (int i=1, j=10; i<=10; i++, j--){   // i와 j가 타입이 같아야하며,
                                                // for문 안에서 선언되었기 때문에 for문 안에서만 사용 가능
            System.out.println("i="+i+", j="+j);
        }
        System.out.println();

        // 변수의 범위 : scope -> 좁을 수록 좋다. (변수가 잘못됐을 경우 확인하는 범위를 좁힐 수 있기 때문에)
        //             선언 위치부터 선원된 블럭의 끝까지 변수의 범위로 지정
        int i;
        for (i=1; i<= 10; i++){
            System.out.println("i= "+i);
        }
        System.out.println(i);
        System.out.println();


        int sum = 0; // 합계를 저장하기 위한 변수
        for (int x=1; x<=5; x++) {
            sum += x;   // sum = sum+x
            System.out.printf("1부터 %2d 까지의 합 : %2d%n", x, sum);
        }
    }
}
