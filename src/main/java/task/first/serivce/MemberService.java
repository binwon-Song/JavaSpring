package task.first.serivce;

import task.first.domain.Member;
import task.first.repository.MemberRepository;
import task.first.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    // 회원 가입
    public Long join(Member member){
//        Optional<Member> result = memberRepository.findByName(member.getName());   // ctrl + alt + v
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicatedMember(Member member) {  // refactor ctrl + shift + alt + t
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{  // 값이 있으면 true or false  값이 있다면 m으로 값을 던지고 m이 람다식을 이행함.
                            throw new IllegalStateException("이미 존재");
                        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();  // ctrl+b Interface로 이동
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
