package hello.hellospring.domain;

public class Member {
    private Long id; // 단순히 시퀀스로 오르는 값. 고객이 정하는 게 아닌 데이터 구분 위해 시스템이 저장하는 ID.
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