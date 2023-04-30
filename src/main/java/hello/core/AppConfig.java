package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /* MemberService가 직접 어떤 구현체를 설정 X 
    *   :: AppConfig가 그 역할 할당을 해주자
    *   ==> "생성자 주입"
    * */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    // 생성자 주입에 관련된 메서드는 각 행동이 뚜렷히 보이게 리팩토링하도록 한다.
    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    // 할인정책에 대해 바꾸고 싶다면 아래 메서드 한 줄만 바꿔주면 된다.
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
