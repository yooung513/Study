import jpql.Member;
import jpql.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_5 {
    // 조인
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
            member.setUsername("teamA");
            member.setAge(10);
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            String innerjoin_query = "select m from Member m inner join m.team t";      // inner 생략 가능
            String outerjoin_query = "select m from Member m left outer join m.team t"; // outer 생략 가능
            String thetajoin_query = "select m from Member m Team t where m.username = t.name";


            // 조인 대상 필터링
            String filter_query = "select m from Member m left join m.team t on t.name = 'teamA'";


            // 연관관계 없는 외부 조인
            String notouter_query = "select m from Member m left join Team t on m.username = t.username";



            List<Member> result = em.createQuery(innerjoin_query, Member.class)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }

        emf.close();
    }
}
