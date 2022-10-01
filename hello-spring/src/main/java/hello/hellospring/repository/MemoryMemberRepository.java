package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {


    private static Map<Long, Member> store = new HashMap<>(); // key : 회원의 ID : Long
    private static long sequence = 0L; // 0..1..2.. key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id 1부터 시작
        store.put(member.getId(), member); // map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null일 경우 대비 -> optional로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //member로 넘어온 getName이 파라미터로 넘어온 name과 같은지 확인. 같은 경우에만 필터링.
                .findAny(); // 찾으면 : 반환
        // 람다식 활용 : 루프로 돌림. filter 사용
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // values() : 멤버들임
    }

    public void clearStore() {
        store.clear();
    }
}

// 위 검증 위해 테스트케이스 작성.(기가막힌 방법)