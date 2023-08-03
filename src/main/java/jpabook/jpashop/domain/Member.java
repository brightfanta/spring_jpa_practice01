package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") // class 단위 + id로 구분할 수 있을 것 같지만, id라고만 적으면 나중에 구분 어려워짐.
    private Long id;

    private String name;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "member") // order table에 있는 member에 의해 결정됨, mapping된 거울일 뿐이고!
    private List<Order> orders = new ArrayList<>();
}
