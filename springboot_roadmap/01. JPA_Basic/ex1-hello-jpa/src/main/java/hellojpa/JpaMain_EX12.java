package hellojpa;

public class JpaMain_EX12 {
    public static void main(String[] args) {
        // 값 타입 - 값 타입의 비교

        int a = 10;
        int b = 10;
        System.out.println("a == b ? " + (a == b));     // true

        Address addressA = new Address("city", "street", "code");
        Address addressB = new Address("city", "street", "code");
        System.out.println("a == b ? " + (addressA == addressB));       // false

        // 동등성 비교 : 정확하게 사용하기 위해서 엔티티에서 재정의 필요
        System.out.println("a equals b ? " + addressA.equals(addressB));

    }
}
