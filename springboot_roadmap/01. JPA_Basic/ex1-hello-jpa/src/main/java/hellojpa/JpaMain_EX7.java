package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_EX7 {

    // 프록시
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

//            // 프록시가 필요한경우
//            Member member = em.find(Member.class, 1L);
//
//            printMember(member);                // member 값만 필요
////            printMemberAndTeam(member);       // member와 team의 연관관계 값 필요


            // 테스트 값 저장
            Member member = new Member();
            member.setName("Hello");

            em.persist(member);

            Member member1 = new Member();
            member1.setName("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("member1");
            em.persist(member2);


            em.flush();
            em.clear();


            // 초기화된 상태 = DB에서 가져온 값

            // 1. em.find()
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            // 2. em.getReference()
            Member refMember = em.getReference(Member.class, member.getId());
            System.out.println("refMember = " + refMember.getClass());
            System.out.println("refMember.id = " + refMember.getId());          // 알고있는 값이므로 쿼리를 호출하지 않음
            System.out.println("refMember.name = " + refMember.getName());
            // print 메소드를 호출하지 않을 때와 할 때의 쿼리가 다름
            // 호출하지 않으면 조회를 하지 않지만 호출 할 때에는 값이 실제 사용되므로 조회하는 쿼리를 호출함


            em.flush();
            em.clear();


            // 타입 비교
            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.find(Member.class, member2.getId());
            Member m2 = em.getReference(Member.class, member2.getId());

            logic(m1, m2);              // false
            checkClassType(m1, m2);     // 둘 다 Member 클래스임을 알 수 있음 (true)
            System.out.println();

            em.flush();
            em.clear();


            // 이미 영속성 컨텍스트에 엔티티가 존재하는 경우 -> 항상 실제 엔티티 반환
            Member findM1 = em.find(Member.class, member1.getId());
            Member refM1 = em.getReference(Member.class, member1.getId());
            System.out.println("findM1 = " + findM1.getClass());
            System.out.println("refM1 = " + refM1.getClass());      // proxy 값이 아닌 실제 Member 클래스 반환
            System.out.println();

            em.flush();
            em.clear();


            // 동일한 영속성 컨텍스트 안에서는 ref와 find의 관계
            Member refMem = em.getReference(Member.class, member1.getId());
            System.out.println("refMem = " + refMem.getClass());    // proxy

            Member findMem = em.find(Member.class, member1.getId());
            System.out.println("findMem = " + findMem.getClass());  // Member가 아닌 proxy로 도출
            System.out.println("refMem == findMem ? " + (refMem == findMem));   // true
            System.out.println();

            em.flush();
            em.clear();


            // 준영속 상태일 때 프록시 초기화 시 문제 발생
            Member reference = em.getReference(Member.class, member1.getId());  // 프록시 호출

            em.detach(reference);       // 영속성 컨텍스트에서 꺼내기

//            System.out.println("reference = " + reference.getName());   // 쿼리 실행 - 실제 값 추출
            // Exception 발생 -> LazyInitializationException


            tx.commit();

        } catch (Exception e) {
            System.out.println("e = " + e);    // 에러 메세지 출력
//            e.printStackTrace(); // 에러로 표현
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2 ? " + (m1.getClass() == m2.getClass()));

    }

    private static void checkClassType(Member m1, Member m2) {
        System.out.println("m1 == m2 ? " + (m1 instanceof Member));
        System.out.println("m1 == m2 ? " + (m2 instanceof Member));
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getName());
    }

    private static void printMemberAndTeam(Member member) {
        String userName = member.getName();
        System.out.println("userName = " + userName);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
