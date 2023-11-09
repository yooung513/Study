package hellojpa;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "테이블 이름")   // 테이블 이름이 다른 경우 이름 매핑
public class Member {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")   // 컬럼 이름이 다른 경우 컬럼 매핑
    private String name;
//    @Column(name = "TEAM_ID")  // 테이블에 맞춘 설계로 객체지향적이지 않음
//    private Long teamId;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")   // 객체지향적인 설계
    private Team team;
    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;
    @ManyToMany
    @JoinTable(name = "member_product")     // 중간 테이블 명 작성
    private List<Product> products = new ArrayList<>();
    private String createBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        // 연관관계 편의 메소드
        team.getMembers().add(this);
    }

//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", team=" + team +    // 이는 team의 toString() 호출 => 무한루프
//                '}';
//    }
}

