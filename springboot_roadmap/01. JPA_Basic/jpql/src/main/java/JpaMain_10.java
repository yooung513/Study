import jpql.Member;
import jpql.MemberType;
import jpql.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class JpaMain_10 {
    // 경로 표현식
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("관리자1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();

            String query1 = "select m.username from Member m";          // 상태필드
            String query2 = "select m.team.member from Member m";       // 단일 값 연관 경로 (묵시적 내부 조인 발생, 탐색 가능)
            String query3 = "select t.members from Team t";             // 컬렉션 값 연관 경로 (묵시적 내부 조인 발생, 탐색 불가)
            String query4 = "select t.members.size from Team t";
            String query5 = "select m.username from Team t join t.members m";    // 3의 탐색을 가능하게 하기 위해 join 사용
                                                                                 // 즉, 컬렉션 값 연관 경로에 명시적 조인

            List<String> result1 = em.createQuery(query1, String.class)
                    .getResultList();
            for (String s : result1) {
                System.out.println("s = " + s);
            }


            Collection result3 = em.createQuery(query3, Collection.class)
                    .getResultList();
            for (Object o : result3) {
                System.out.println("o = " + o);
            }


            Integer result4 = em.createQuery(query4, Integer.class)
                    .getSingleResult();
            System.out.println("result4 = " + result4);




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
