package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("memberA");
            member.setAge(10);
            em.persist(member);


            // 반환 타입
            TypedQuery<Member> query_Member = em.createQuery("select m from Member m", Member.class);
            TypedQuery<String> query_String = em.createQuery("select m.username from Member m", String.class);
            Query query_Object = em.createQuery("select m.username, m.age from Member m");      // 반환타입이 명확하지 않을 때 사용


            // 반환 값의 개수
            List<Member> resultList = query_Member.getResultList();     // 반환 값이 여러개
            for (Member mem : resultList) {
                System.out.println("mem = " + mem);
            }

            TypedQuery<String> findById = em.createQuery("select m.username from Member m where m.id = 1", String.class);
            String username = findById.getSingleResult();
            System.out.println("username = " + username);


            // 파라미터 바인딩
            Member singleResult = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "memberA")
                    .getSingleResult();
            System.out.println("singleResult = " + singleResult.getUsername());

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
