package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_EX4 {

    // 연관 관계 매핑
    public static void main(String[] args) {
        // 일대다 매핑

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = saveMember(em);

            Team team = new Team();
            team.setName("teamA");

            team.getMembers().add(member);      // team에 설정을 했지만 member 쿼리도 같이 호출됨 -> 복잡성 증가
                                                // 따라서 실무에서는 일대다 관계를 지양하고
                                                // 다대일 양방향 매핑을 지향한다.

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static Member saveMember(EntityManager em) {
        Member member = new Member();
        member.setName("member1");

        em.persist(member);
        return member;
    }
}
