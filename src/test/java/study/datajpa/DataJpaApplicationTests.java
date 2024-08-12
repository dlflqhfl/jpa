package study.datajpa;

import jakarta.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberRepository;


import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
class DataJpaApplicationTests {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void contextLoads() {
        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).get();

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

}
