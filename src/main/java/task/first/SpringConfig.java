package task.first;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task.first.repository.JdbcMemberRepository;
import task.first.repository.MemberRepository;
import task.first.repository.MemoryMemberRepository;
import task.first.serivce.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean   //Spring Bean 에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());

    }
    @Bean MemberRepository memberRepository(){

        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
