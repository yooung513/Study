import jpql.Address;
import jpql.Member;
import jpql.MemberDTO;
import jpql.Team;

import javax.persistence.*;
import java.util.List;

public class JpaMain_3 {
    // 프로젝션 (SELECT)
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

            em.flush();
            em.clear();


            // 엔티티 프로젝션
            List<Member> result = em.createQuery("select m from Member m ", Member.class)
                    .getResultList();

            Member findMember = result.get(0);
            findMember.setAge(20);  // 값이 변경됨을 확인 = 영속성 컨텍스트에서 관리


            List<Team> result_Team1 = em.createQuery("select m.team from Member m", Team.class)
                    .getResultList();
            List<Team> result_Team2 = em.createQuery("select t from Member m join m.team t", Team.class)
                    .getResultList();   // 예측 가능하도록 쿼리문을 위와같이 작성해야함



            // 임베디드 프로젝션
            List<Address> result_Address = em.createQuery("select o.address from Order o", Address.class)
                    .getResultList();



            // 스칼라 타입 프로젝션
            List result_scala = em.createQuery("select distinct m.username, m.age from Member m")
                    .getResultList();



            // 여러 값 조회
            // 1. Query 타입으로 조회
            Query query = em.createQuery("select m.username, m.age from Member m");


            // 2. Object[] 타입으로 조회
            List resultList1 = em.createQuery("select m.username, m.age from Member m")
                    .getResultList();

            Object o1 = resultList1.get(0);
            Object[] res1 = (Object[]) o1;
            System.out.println("username = " + res1[0]);
            System.out.println("age = " + res1[1]);


            List<Object[]> resultList2 = em.createQuery("select m.username, m.age from Member m")
                    .getResultList();

            Object[] res2 = resultList2.get(0);
            System.out.println("username = " + res2[0]);
            System.out.println("age = " + res2[1]);


            // 3. new 명령어로 조회 -> 가장 깔끔
            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();

            MemberDTO memberDTO = resultList.get(0);
            System.out.println("memberDTO.getUsername = " + memberDTO.getUsername());
            System.out.println("memberDTO.getAge = " + memberDTO.getAge());

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
