package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_EX10 {

    // 값 타입 - 임베디드 타입
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Member member = new Member();
            member.setName("hello");
            member.setHomeAddress(new Address("city", "street", "1000"));
            member.setWorkPeriod(new Period());

            em.persist(member);

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
