package hellojpa;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_EX9 {

    // 프록시 - 영속성 전이와 고아 객체
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // 영속성 전이
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

//            em.persist(child1);       // 영속성 전이시 부모 엔티티가 저장될 때
//            em.persist(child2);       // 자동으로 함께 저장됨
            em.persist(parent);

            em.flush();
            em.clear();


            // 고아 객체
            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);    // 고아 객체 생성 -> 첫번째 객체 제거됨

            em.remove(findParent);      // 부모 객체가 지워짐에 따라 자식객체 또한 함께 지워짐


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
