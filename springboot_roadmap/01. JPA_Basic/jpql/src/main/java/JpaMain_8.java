import jpql.Member;
import jpql.MemberType;
import jpql.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_8 {
    // 조건식 (CASE 응용)
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
            member.setUsername("관리자");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.ADMIN);
            em.persist(member);

            Member member1 = new Member();
            member1.setUsername(null);
            member1.setAge(20);
            member1.setTeam(team);
            member1.setType(MemberType.ADMIN);
            em.persist(member1);

            em.flush();
            em.clear();

            // 기본 case 식
            String query1 = "select "+
                                "case when m.age <= 10 then '학생요금' " +
                                "     when m.age >= 60 then '경로요금' " +
                                "     else '일반요금' " +
                                "end " +
                            "from Member m";
            List<String> resultList1 = em.createQuery(query1, String.class)
                    .getResultList();

            for (String s : resultList1) {
                System.out.println("s = " + s);
            }


            // coalesce : 하나씩 조회해서 null이 아니면 반환
            String query2 = "select coalesce(m.username, '이름없는 회원') from Member m ";
            List<String> resultList2 = em.createQuery(query2, String.class)
                    .getResultList();
            for (String s : resultList2) {
                System.out.println("s = " + s);
            }


            // nullif : 두 값이 같으면 null 반환, 다르면 첫번째 값 반환
            String query3 = "select nullif(m.username, '관리자') from Member m ";
            List<String> resultList3 = em.createQuery(query3, String.class)
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
