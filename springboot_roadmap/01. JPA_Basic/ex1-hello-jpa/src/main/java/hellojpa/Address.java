package hellojpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String city;
    private String street;

//    @Column(name = "zip_code")
    private String zipCode;
//    private Member member;    // 임베디드 타입에 엔티티 값 입력 가능


    public Address() {
    }

    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

//    public void setCity(String city) {    // Setter 값을 지우는 순간 값을 참조할 수 없음
//        this.city = city;                 // -> 불변 객체
//    }

    public String getStreet() {
        return street;
    }

//    public void setStreet(String street) {
//        this.street = street;
//    }

    public String getZipCode() {
        return zipCode;
    }

//    public void setZipCode(String zipCode) {
//        zipCode = zipCode;
//    }


    @Override
    public boolean equals(Object o) {   // 동등성 비교를 위한 메소드
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipCode);
    }
}
