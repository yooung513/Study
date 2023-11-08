package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_EX3 {

    // 연관 관계 매핑
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // 저장
//            Member member1 = new Member();
//            member1.setName("memberA");
//            em.persist(member1);
//
//            Team team1 = new Team();
//            team1.setName("TeamA");
//            team1.getMembers().add(member1);
//            em.persist(team1);
//
//            em.flush();
//            em.clear();
//
//            tx.commit();

            // insert 쿼리가 두 번 들어갔지만, member 데이터를 보면 team 값이 null로 설정됨
            // => mappedBy는 읽기 전용으로 취급되기 때문에 (가짜 맵핑)
            // 따라서 Team을 먼저 저장한 후 Member를 저장해야 한다.
            // 즉, 연관관계의 주인을 기준으로 맵핑한다. (연관관계의 주인에 값을 넣어줌)

//            Team team2 = new Team();
//            team2.setName("TeamB");
//            em.persist(team2);
//
//            Member member2 = new Member();
//            member2.setName("memberB");
//            member2.setTeam(team2);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            tx.commit();


            // 양방향 매핑시 연관관계의 주인에 양쪽 다 값을 입력하기
            // 가짜매핑에 값을 넣어주지 않아도 데이터를 통해 값을 가져올 수 있지만,
            // 객체지향의 의미가 저하되며,
            // flush와 clear가 없는 경우 1차 캐시 안에 있는 값이 그대로 조회가 되기 떄문에
            // 데이터에 반영된 값이 조회 되지 않음 (=> 메모리에 있는 빈 값이 출력됨)
            // 또한, 테스트 케이스에서는 순수한 자바 코드 상태에서 작성하게 되는데 값이 다르게 도출됨
            // 따라서 양방향 연관관계에서는 양쪽에 값을 다 설정해주어야 한다.
//            Team team2 = new Team();
//            team2.setName("TeamC");
//            em.persist(team2);
//
//            Member member2 = new Member();
//            member2.setName("memberC");
//            member2.setTeam(team2);             // ** (양방향 매핑)
//            em.persist(member2);
//
//            team2.getMembers().add(member2);    // **
//
//            em.flush();
//            em.clear();
//
//            tx.commit();


            // 실수를 방지하기 위해서 연관관계 편의 메소드를 Member에 생성
            // team2.getMembers().add(member2);를 setTeam()에 같이 호출
            // 이때 기존 값을 그냥 넣는 것이 아니라 로직이 추가된 것으로
            // 메소드의 이름을 set이 아닌 다른걸로 변경해주면 좋다.
            // 또한, 연관관계 메소드는 둘 중 하나만 작성해준다. (편의에 따라 선택)

            // member에 편의 메소드를 추가한 경우
            Team team3 = new Team();
            team3.setName("TeamC");
            em.persist(team3);

            Member member2 = new Member();
            member2.setName("memberC");
            member2.changeTeam(team3);
            em.persist(member2);


            // Team에 편의 메소드를 추가한 경우
            Team team4 = new Team();
            team4.setName("TeamD");
            em.persist(team4);

            Member member4 = new Member();
            member4.setName("memberD");
            em.persist(member4);

            team4.addMember(member4);

            em.flush();
            em.clear();

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
