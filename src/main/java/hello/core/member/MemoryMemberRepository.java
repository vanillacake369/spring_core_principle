package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{
//    동시1성 이슈 때문에 HashMap 지양 => ConcurrnetHashMap 사용 권장
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        // id(key) => member REF (value)
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
