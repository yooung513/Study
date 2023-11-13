package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class JpaMain_EX13 {

    // 객체지향 쿼리 언어 (JPQL)
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // JPQL 기본
            List<Member> result = em.createQuery(
                    "select m From Member m where m.username like '%kim%'",
                    Member.class
            ).getResultList();


            // Criteria
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> from = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(from);
            String username = "lee";
            if (username != null) {
                cq = cq.where(cb.equal(from.get("username"), "kim"));
            }

            List<Member> resultList = em.createQuery(cq)
                    .getResultList();


            // QueryDSL -> 셋팅 필요 (실무 사용 권장)


            // 네이티브 SQL
            List resultNativeSQL = em.createNativeQuery("select MEMBER_ID, city, streete, zipcode, USERNAME from MEMBER")
                    .getResultList();


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
