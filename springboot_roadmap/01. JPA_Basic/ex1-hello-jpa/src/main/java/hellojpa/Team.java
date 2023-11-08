package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @OneToMany(mappedBy = "team")   // mappedBy : 매핑할 '변수 명'을 적어줌 (Team의 team)
    private List<Member> members = new ArrayList<>();

    void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    }


    // getter and setter
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


    //    @Override
    //    public String toString() {
    //        return "Team{" +
    //                "id=" + id +
    //                ", name='" + name + '\'' +
    //                ", members=" + members +  // members의 toString() 호출 => 무한 루프
    //                '}';
    //    }
}
