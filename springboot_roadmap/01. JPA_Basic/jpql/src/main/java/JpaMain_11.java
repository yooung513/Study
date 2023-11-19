import jpql.Member;
import jpql.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class JpaMain_11 {
    // 페치 조인 1 - 기본
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

            String query1 = "select m from Member m";
            String query2 = "select m from Member m join fetch m.team";
            String query3 = "select t from Team t join fetch t.members";    // 컬렉션 페치 조인
            String query4 = "select distinct t from Team t join fetch t.members";    // 애플리케이션에서 중복 제거


            List<Member> result1 = em.createQuery(query1, Member.class)
                    .getResultList();
            for (Member member : result1) {
                System.out.println("member = " + member);
                System.out.println("member's name and team = " + member.getUsername() + ", " + member.getTeam().getName());
            }

            List<Member> result2 = em.createQuery(query2, Member.class)
                    .getResultList();
            for (Member member : result2) {
                System.out.println("member's name and team = " + member.getUsername() + ", " + member.getTeam().getName());
            }

            List<Team> result3 = em.createQuery(query3, Team.class)
                    .getResultList();
            for (Team team : result3) {
                System.out.println("team = " + team.getName() + ", members = " + team.getMembers().size());
                for (Member member : team.getMembers()) {
                    System.out.println("-> member = " + member);
                }
            }

            List<Team> result4 = em.createQuery(query4, Team.class)
                    .getResultList();
            for (Team team : result4) {
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