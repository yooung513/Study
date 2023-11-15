import jpql.Member;
import jpql.MemberType;
import jpql.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_7 {
    // JPQL 타입 표현과 기타식
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
            member.setType(MemberType.ADMIN);
            em.persist(member);

            em.flush();
            em.clear();

            String query = "select m.username, 'HELLO', true from Member m " +
                           " where m.type = jpql.MemberType.ADMIN";
            List<Object[]> result = em.createQuery(query)
                    .getResultList();

            // 파라미터로 표현
            String query_ = "select m.username, 'HELLO', true from Member m " +
                            " where m.type = :userType";
            List<Object[]> result_ = em.createQuery(query)
                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();


            // 기타 표현식
            String between_query = "select m.username, 'HELLO', true from Member m " +
                                    " where m.age between 0 and 10";

            for (Object[] objects : result) {
                System.out.println("objects = " + objects[0]);
                System.out.println("objects = " + objects[1]);
                System.out.println("objects = " + objects[2]);
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
