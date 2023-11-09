package ch6;

public class Ex24 {
    public static void main(String[] args) {                // 1. main() 호출
        Data2 data = new Data2();                           // 2. Data2 객체 생성
        data.x = 10;                                        // 3. Data2 클래스에 있는 지역변수 x에 10 대입
                                                            //    -> Data2{ x[10] }
        System.out.println("main() : x = " + data.x);       // 4. println() 메소드 호출 (실행-종료)

        change(data);                                       // 5. change() 호출 (참조형 변수 data 값 전달)
        System.out.println("After change(data)");           // 10. println() 메소드 호출 (실행-종료)
        System.out.println("main() : x = " + data.x);       // 11. println() 메소드 호출 (실행-종료)
    }                                                       // 12. main() 종료

    static void change(Data2 data) {    // 참조형 매개변수      // 6. change() 실행 (변수값 : data 복사 - 참조형 매개변수)
        data.x = 1000;                                      // 7. 참조변수 data의 x 값에 1000 대입
                                                            //    -> Data2{ x[1000] }
        System.out.println("change() : x = " + data.x);     // 8. println() 메소드 호출 (실행-종료)
    }                                                       // 9. change() 종료
 }

class Data2 {
    int x;
}
