package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        /**
         * 다만, 정적 메서드에 대해 @Bean을 사용하게 되면 싱글톤이 보장되지 않는다.
         * :: https://www.inflearn.com/questions/609357/appconfig-class%EC%97%90%EC%84%9C-%EB%B9%88%EC%9D%84-%EB%93%B1%EB%A1%9D%ED%95%98%EB%8A%94-%EB%A9%94%EC%84%9C%EB%93%9C%EA%B0%80-static-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%BC-%EB%95%8C
         * */
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = memberService.getMemberRepository();
        MemberRepository memberRepository1 = orderService.getMemberRepository();

        System.out.println("memberRepository : "+memberRepository);
        System.out.println("memberRepository1 : "+memberRepository1);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println(bean.getClass());

    }

}
