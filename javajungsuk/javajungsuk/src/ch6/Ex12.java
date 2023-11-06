package ch6;

public class Ex12 {
    public static void main(String[] args) {

        System.out.println("Card.width = " + Card.width);   // cv는 객체의 생성 없이 바로 사용이 가능
        System.out.println("Card.height = " + Card.height);

        Card c1 = new Card();   // 객체 생성
        c1.kind = "Heart";      // iv는 객체가 생성되어야 사용 가능
        c1.number = 7;

        Card c2 = new Card();   // 객체가 생성될 때마다 별개의 iv 생성
        c2.kind = "Spade";
        c2.number = 2;

        System.out.printf("c1은 %s, %d이며, 크기는 (%d, %d) 입니다.%n", c1.kind, c1.number, Card.width, Card.height);
        System.out.printf("c2는 %s, %d이며, 크기는 (%d, %d) 입니다.%n", c2.kind, c2.number, Card.width, Card.height);

        c1.width = 50;      // iv가 아닌 cv이므로 클래스 내부의 값이 변경됨
        c1.height = 80;     // 따라서 Card 클래스를 작성해서 오해를 방지
        System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
        System.out.printf("c1은 %s, %d이며, 크기는 (%d, %d) 입니다.%n", c1.kind, c1.number, Card.width, Card.height);
        System.out.printf("c2는 %s, %d이며, 크기는 (%d, %d) 입니다.%n", c2.kind, c2.number, Card.width, Card.height);

    }
}
class Card {
    static int width = 100;
    static int height = 250;

    String kind;
    int number;
}