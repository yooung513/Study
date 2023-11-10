package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain_EX13 {

    // 값 타입 - 값 타입 컬렉션
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // 값 타입 저장 예제
            Member member = new Member();
            member.setName("user1");
            member.setHomeAddress(new Address("home city", "street", "zipcode"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressList().add(new Address("old city A", "street", "zipcode"));
            member.getAddressList().add(new Address("old city B", "street", "zipcode"));

            em.persist(member);

            em.flush();
            em.clear();


            // 값 타입 조회 예제
            Member findMember = em.find(Member.class, member.getId());  // 지연로딩으로 값을 조회함

            // 해당 값을 호출할 때 쿼리문 호출 (지연 로딩)
            List<Address> findAddressList = findMember.getAddressList();
            for (Address address : findAddressList) {
                System.out.println("address_city = " + address.getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }

            em.flush();
            em.clear();


            // 값 타입 수정 예제 -> 일부 변경이 아닌 완전 교체로 수정해야 함
            Member findMem = em.find(Member.class, member.getId());

            // homeCity -> newCity
//            findMem.getHomeAddress().setCity("newCity"); // 값 참조 변경됨 -> 불변 객체로 변경
            Address oldAddress = findMem.getHomeAddress();
            findMem.setHomeAddress(new Address("newCity", oldAddress.getStreet(), oldAddress.getZipCode()));

            // 값 타입 컬렉션 수정
            // 치킨 -> 돈까스
            findMem.getFavoriteFoods().remove("치킨");
            findMem.getFavoriteFoods().add("돈까스");

            // old city A -> new city A

            findMem.getAddressList().remove(new Address("old city A", "street", "zipcode"));
            findMem.getAddressList().add(new Address("new city A", "street", "zipcode"));



            // 값 타입 컬렉션의 대안 방법 - 일대다 매핑
            findMem.getAddressHistory().add(new AddressEntity("new city A", "street", "zipcode"));


            tx.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);    // 에러 메세지 출력
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
