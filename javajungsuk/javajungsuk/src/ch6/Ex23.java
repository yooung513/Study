package ch6;

import java.util.Date;

public class Ex23 {
    public static void main(String[] args) {                // 1. 스택 호출 main() 실행
        Data data = new Data();                             // 2. 객체 생성
        data.x = 10;                                        // 3. 지역변수 data에 있는 x값에 10 대입
                                                            //    -> Data{ x[10] }
        System.out.println("main() : x = " + data.x);       // 4. println() 메소드 호출 (실행-종료)

        change(data.x);                                     // 5. change() 메소드 호출 (data.x 값[10] 전달 )
        System.out.println("After change(data.x)");         // 10. println() 메소드 호출 (실행-종료)
        System.out.println("main() : x = " + data.x);       // 11. println() 메소드 호출 (실행-종료)
    }                                                       // 12. main() 종료

    static void change(int x) { // x : 기본형 매개변수          // 6. change 메소드 실행 (main() 메소드의 지역 변수값 10)
        x = 1000;                                           // 7. change() 메소드의 지역변수 x에 1000 대입
                                                            //    -> Change{ x[1000] - 기본형 매개변수이므로 읽기만 가능 }
        System.out.println("change() : x = " + x);          // 8. println() 메소드 호출 (실행-종료)
    }                                                       // 9. change 메소드 종료
}

class Data {
    int x;
}