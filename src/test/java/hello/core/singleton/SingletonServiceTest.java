package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonServiceTest {
    @Test
    @DisplayName("싱글톤 패턴 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 : "+singletonService1);
        System.out.println("singletonService2 : "+singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
        MemberService memberService2 = annotationConfigApplicationContext.getBean("memberService", MemberService.class);

        System.out.println("memberService1 : "+memberService1);
        System.out.println("memberService1 detail : "+memberService1.getClass()); // > MemberServiceImpl
        System.out.println("memberService2 : "+memberService2);
        System.out.println("memberService2 detail : "+memberService2.getClass()); // > MemberServiceImpl

        assertThat(memberService1).isSameAs(memberService2);
    }
}
