package hellojpa;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
//@Table(name = "테이블 이름")   // 테이블 이름이 다른 경우 이름 매핑
public class Member extends BaseEntity{
    @Id @GeneratedValue
    private Long id;

    @Column(name = "username")   // 컬럼 이름이 다른 경우 컬럼 매핑
    private String name;
//    @Column(name = "TEAM_ID")  // 테이블에 맞춘 설계로 객체지향적이지 않음
//    private Long teamId;

    @ManyToOne(fetch = FetchType.EAGER) // 즉시로딩
//    @ManyToOne(fetch = FetchType.LAZY)  // 지연로딩 => 해당 값을 프록시로 가지고 옴
    @JoinColumn(name = "team_id")   // 객체지향적인 설계 // , insertable = false, updatable = false
    private Team team;
//    @OneToOne
//    @JoinColumn(name = "locker_id")
//    private Locker locker;
//    @ManyToMany
//    @JoinTable(name = "member_product")     // 중간 테이블 명 작성
//    private List<Product> products = new ArrayList<>();

    @Embedded                   // 임베디드 타입
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "favorite_food",
                    joinColumns = @JoinColumn(name = "member_id")       // 외래키로 생성
    )
    @Column(name = "food_name")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "address",
                    joinColumns = @JoinColumn(name = "member_id")
    )
    private List<Address> addressList = new ArrayList<>();      // 값 타입 컬렉션 매핑

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<AddressEntity> addressHistory = new ArrayList<>(); // 값 타입 컬렉션의 대안 (일대다 매핑)

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",
                               column = @Column(name = "work_city")),
            @AttributeOverride(name = "street",
                               column = @Column(name = "work_street")),
            @AttributeOverride(name = "zipCode",
                               column = @Column(name = "work_zipcode"))
    })
    private Address workAddress;


    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

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

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
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