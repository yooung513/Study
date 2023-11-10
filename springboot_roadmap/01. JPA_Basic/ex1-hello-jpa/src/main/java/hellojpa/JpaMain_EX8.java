package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;

public class JpaMain_EX8 {

    // 프록시 - 즉시로딩과 지연 로딩
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMem = em.find(Member.class, member.getId());

            // 지연 로딩 = 프록시 객체 / 즉시 로딩 = Team 객체
            System.out.println("findMem = " + findMem.getTeam().getClass());


            // 즉시로딩 사용 시 문제점 : JPQL에서 N+1 문제 발생
            List<Member> members = em.createQuery("select m from Member m", Member.class)

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
