package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// 1. 스프링 컨테이너에 등록하면
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // 2. 생성자 호출  3.@Autowired가 있으면 스프링 컨테이너에 있는 MemberService에 memberRepository를 넣어줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // DI(의존성 주입)
    }

    //회원 가입
    public Long join(Member member) {
        // 같은 이름 회원 X
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);   // 검증 통과 하면? -> 저장
        return member.getId();           // 저장값 반환
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                     throw new IllegalStateException("이미 존재하는 회원입니다.");
                 });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
