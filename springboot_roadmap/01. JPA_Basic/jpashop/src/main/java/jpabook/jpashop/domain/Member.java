package jpabook.jpashop.domain;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "member")                 // 실제로는 관심사 설정을 끊어야하지만, 예제이므로 양방향 연관관계 설정
    private List<Order> orders = new ArrayList<>();

    @Embedded
    private Address address;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
