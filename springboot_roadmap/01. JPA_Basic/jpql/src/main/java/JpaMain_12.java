import jpql.Member;
import jpql.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_12 {
    // 페치 조인 2 - 한계
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();


            // 한계 1. 조인 대상에 별칭을 주지 않는다.
            String query1 = "select t from Team t join fetch t.members as m";


            // 한계 3. 컬렉션을 페치조인하면 페이징을 사용하지 않는다.
            String query2 = "select t from Team t join fetch t.members";

            List<Team> result1 = em.createQuery(query2, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(1)
                    .getResultList();

            // 한계 3_해결 1. 다대일로 연관관계 방향을 바꿔서 문제를 해결한다.
            String query3 = "select m from Member m join fetch m.team t";

            // 한계 3_해결 2. @BatchSize 사용
            String query4 = "select t From team t";
            List<Team> result2 = em.createQuery(query4, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .getResultList();

            for (Team team : result2) {
                System.out.println("team = " + team.getName() + ", members = " + team.getMembers().size());
                for (Member member : team.getMembers()) {
                    System.out.println("-> member = " + member);
                }
            }

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
