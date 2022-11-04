package oclock.oclock.service;

import oclock.oclock.domain.Member;
import oclock.oclock.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@Commit
class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setPassword("test password");
        member.setName("test name");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getEmail(), findMember.getEmail());
        assertEquals(member.getPassword(), findMember.getPassword());
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_이메일_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setEmail("test123@gmail.com");
        member1.setName("member1 name");
        member1.setPassword("member1 password");

        Member member2 = new Member();
        member2.setEmail("test123@gmail.com");
        member2.setName("member2 name");
        member2.setPassword("member2 password");

        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2)); //예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
