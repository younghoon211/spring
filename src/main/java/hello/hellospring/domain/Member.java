package hello.hellospring.domain;

import javax.persistence.*;

@Entity // Mapping
public class Member { // JPA가 관리하는 엔티티

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //identity : id와 같은 시퀀스처럼 db가 자동으로 생성해주는 것
    private Long id; // 단순히 시퀀스로 오르는 값. 고객이 정하는 게 아닌 데이터 구분 위해 시스템이 저장하는 ID.

//    @Column(name = "username")  <- db에 있는 name이 username일 경우 자동 매핑
    private String name; // 고객이 적는 name

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