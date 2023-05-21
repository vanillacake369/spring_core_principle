package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    static class TestConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

    @Test
    @DisplayName("공유 변수가 생긴 상황에서의 문제점")
    void statefulServiceSinglton(){
        // 위에서 생성한 StatefulService을 컨테이너에 빈으로서 등록
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = annotationConfigApplicationContext.getBean(StatefulService.class);
        StatefulService statefulService2 = annotationConfigApplicationContext.getBean(StatefulService.class);

        // Thread A : A사용자 10000원 주문
        /*statefulService1.order("userA",10000);*/
        int priceA = statefulService1.order("userA",10000);
        // Thread B : B사용자 20000원 주문
        /*statefulService1.order("userB",20000);*/
        int priceB = statefulService2.order("userB",20000);

        // Thread A : 사용자 A 주문 금액 조회
        /*int price = statefulService1.getPrice(); // 원하는 값 : 10000, 실제 조회 값 : 20000*/


//        System.out.println("price : " + price);
        System.out.println("priceA : " + priceA);

        org.assertj.core.api.Assertions.assertThat(priceA).isEqualTo(10000);
        org.assertj.core.api.Assertions.assertThat(priceB).isEqualTo(20000);
    }

}