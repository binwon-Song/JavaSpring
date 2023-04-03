package task.first;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task.first.repository.MemberRepository;
import task.first.repository.MemoryMemberRepository;
import task.first.serivce.MemberService;

@Configuration
public class SpringConfig {

    @Bean   //Spring Bean 에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());

    }
    @Bean MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
