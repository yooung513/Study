package ch6;

public class Ex6 {
    public static void main(String[] args) {

        TV t = new TV();    // 참조 변수 t를 선언하여 생성된 TV 객체와 연결
        t.channel = 7;      // TV 인스턴스의 변수 값을 7로 초기화
        t.channelDown();    // TV 인스턴스의 메소드 호출
        System.out.println("현재 채널은 " + t.channel + "번 입니다.");
        System.out.println();


        TV t1 = new TV();
        TV t2 = new TV();
        System.out.println("t1의 channel 값은 " + t1.channel + "번 입니다.");
        System.out.println("t2의 channel 값은 " + t2.channel + "번 입니다.");
        System.out.println();

        t1.channel = 7;
        System.out.println("t1의 channel 값을 7로 변경했습니다.");

        System.out.println("t1의 channel 값은 " + t1.channel + "번 입니다.");
        System.out.println("t2의 channel 값은 " + t2.channel + "번 입니다.");
        // 이를 통해 객체마다 별도의 저장공간을 가지고 있음을 알 수 있다.

        System.out.println();

        t2 = t1;
        System.out.println("t1의 channel 값은 " + t1.channel + "번 입니다.");
        System.out.println("t2의 channel 값은 " + t2.channel + "번 입니다.");
        // 기존 객체는 참조변수가 없어져 사용 불가가 되어 GC에 의해 사라진다.
    }
}

class TV {
    // TV의 속성 (멤버 변수)
    String color;
    boolean power;
    int channel;


    // TV의 기능 (메소드)
    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }

}
