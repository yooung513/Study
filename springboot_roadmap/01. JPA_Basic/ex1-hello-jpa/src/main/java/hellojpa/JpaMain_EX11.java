package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_EX11 {

    // 값 타입 - 값 타입과 불변 객체
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // 값 타입 : 값 공유 가능
            Address address = new Address("city", "street", "1000");

            Member member1 = new Member();
            member1.setName("member1");
            member1.setHomeAddress(address);
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("member2");
            member2.setHomeAddress(address);
            em.persist(member2);

//            member1.getHomeAddress().setCity("newCity");  // 불변 객체는 값을 변경할 수 없음


            // 불변 객체 : 값 공유 불가능
            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipCode());
            Member member3 = new Member();
            member3.setName("member3");
            member3.setHomeAddress(copyAddress);
            em.persist(member3);

            
            // 불변 객체의 값을 바꾸는 방법 -> 새로 생성해서 값 할당
            Address newCity = new Address("newCity", address.getStreet(), address.getZipCode());
            Member member4 = new Member();
            member4.setName("member4");
            member4.setHomeAddress(newCity);
            em.persist(member4);

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
