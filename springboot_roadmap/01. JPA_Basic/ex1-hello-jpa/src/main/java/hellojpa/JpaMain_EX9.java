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
            Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member1 = new Member();
            member1.setName("member1");
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("member2");
            member2.setTeam(team2);
            em.persist(member2);

            em.flush();
            em.clear();

            Member findMem = em.find(Member.class, member1.getId());

            // 지연 로딩 = 프록시 객체 / 즉시 로딩 = Team 객체
            System.out.println("findMem = " + findMem.getTeam().getClass());


            // 즉시로딩 사용 시 문제점 : JPQL에서 N+1 문제 발생
            // member2 query가 나가고, 즉시로딩에 의해 team을 조회하는 쿼리또한 같이 나가게 됨
            // SQL : select * from member2
            // SQL : select * from team1 where team_id = ?       => 즉시로딩을 지양해야하는 이유
            List<Member> members = em.createQuery("select m from Member m", Member.class)
                            .getResultList();

            tx.commit();

        } catch (Exception e) pu
            System.out.println("e = " + e);    // 에러 메세지 출력
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
