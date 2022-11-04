package oclock.oclock.service;

import oclock.oclock.domain.Member;
import oclock.oclock.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    public MemberService(MemberRepository memberRepository) {   // dependency injection (D.I)
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;


    // 회원 가입
    public Long join(Member member) {
        // 같은 이름의 중복 회원 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
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
