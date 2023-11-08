package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_Ex2 {

    // 객체 지향 설계
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);           // 영속성 컨테스트에 team 정보 저장

            // 회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);       // 단방향 연관관계 설정, 참조 저장
            em.persist(member);

            em.flush();     // 영속성 컨테스트의 값이 아닌 DB에서 값을 출력하기 위한 작업
            em.clear();

            // 조회
            Member findMember = em.find(Member.class, member.getId());

            // 참조를 사용해서 연관관계 조회
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName = " + findTeam.getName());
            
            // 양방향 연관관계를 이용해서 팀에서 멤버를 찾음
            // 즉, 팀에 속해있는 전체 멤버들의 값을 받아옴
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m = " + m.getName());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}