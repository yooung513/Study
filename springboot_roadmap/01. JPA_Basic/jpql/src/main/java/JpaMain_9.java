import jpql.Member;
import jpql.MemberType;
import jpql.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_9 {
    // JPQL 기본함수
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
            member.setUsername("관리자1");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.ADMIN);
            em.persist(member);

            Member member1 = new Member();
            member1.setUsername("관리자2");
            member1.setAge(20);
            member1.setTeam(team);
            member1.setType(MemberType.ADMIN);
            em.persist(member1);

            em.flush();
            em.clear();

            // 기본 함수
            String concat1 = "select concat('a', 'b') from Member m";
            String concat2 = "select 'a' || 'b' from Member m";     // 하이버네이트 구현체 지원
            String substring = "select substring(m.username, 2, 3) from Member m";
            String locate = "select locate('de', 'abcdefg') from Member m";
            String size = "select size(t.members) from Team t";
            String index = "select index(t.members) from Team t";

            // 사용자 정의 함수
            String function1 = "select function('group_concat', m.username) from Member m";
            String function2 = "select group_concat(m.username) from Member m";


            List<String> resultList1 = em.createQuery(substring, String.class)
                    .getResultList();
            for (String s : resultList1) {
                System.out.println("s = " + s);
            }

            List<Integer> resultList2 = em.createQuery(locate, Integer.class)
                    .getResultList();
            for (Integer i : resultList2) {
                System.out.println("i = " + i);
            }

            List<String> resultList3 = em.createQuery(function1, String.class)
                    .getResultList();
            for (String s : resultList3) {
                System.out.println("s = " + s);
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
