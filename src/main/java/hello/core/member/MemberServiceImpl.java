package hello.core.member;

public class MemberServiceImpl implements MemberService{
//    MemberServiceImpl가 어떤 구현체를 사용할지 직접 결정
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    외부에서 어떤 구현체를 사용할지 결정해줌. MemberServiceImpl는 다형성에 대한 Act만 충실히 해주면 됨!
    => SRP!!
    */
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemoryMemberRepository memoryMemberRepository) {
        this.memberRepository = memoryMemberRepository;
    }

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
