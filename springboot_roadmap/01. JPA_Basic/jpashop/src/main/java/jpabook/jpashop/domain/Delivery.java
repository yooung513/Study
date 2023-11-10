package jpabook.jpashop.domain;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity  {

    @Id @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
    @OneToOne
    private Order order;


}
