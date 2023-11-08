package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "테이블 이름")   // 테이블 이름이 다른 경우 이름 매핑
public class Member {
    @Id
    private Long id;

//    @Column(name = "컬럼 이름")   // 컬럼 이름이 다른 경우 컬럼 매핑
    private String name;

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
}
