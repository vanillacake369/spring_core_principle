package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /*인터페이스 변수 => 구현체 객체
    * :: 인터페이스와 구현체 모두 사용
    * => 인터페이스와 구현체 둘 다 의존!!!
    * */
    @Override
    public void join(Member member) {
        /*
        * 다형성 사용
        * MemoryMemberRepository : save (id(key) => member REF(value))
        * */
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        /*
         * 다형성 사용
         * MemoryMemberRepository : store.get(memberId);
         * */
        return memberRepository.findById(memberId);
    }
}
