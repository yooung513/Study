package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {   // 오류 발생 상황을 대비해 try-catch 문법 활용 (정석 코드)

            // member 객체 생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member);


            // member 객체 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getName());


            // JPQL을 사용한 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }


            // 영속성 컨텍스트
            // 비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA");


            // 영속
            em.persist(member);     // 바로 DB에 저장되지 않는 것을 알 수 있음 (SQL 쿼리문이 실행되지 않음)

            tx.commit();            // 트랜잭션이 commit하는 시점에 SQL문이 실행됨
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}