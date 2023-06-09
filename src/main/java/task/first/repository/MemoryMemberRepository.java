package task.first.repository;

import org.springframework.stereotype.Repository;
import task.first.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{
    private  static Map<Long,Member> store=new HashMap<>();
    private  static long sequence =0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member ;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));  // null 일수도 아닐수도 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member-> member.getName().equals(name)) // member의 name이란 이름이 있는지 찾으면 바로 반환
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
