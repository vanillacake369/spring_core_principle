package hello.core.beandefinition;

import hello.core.AppConfig;
import hello.core.beanfind.ApplicationContextExtendsFindTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        // AnnotationConfigApplicationContext의 BeanDefinition들의 이름들을 String배열으로 가져옴
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // 각 BeanDefinition들의 이름들에 대해
        for(String beanDefinitionName : beanDefinitionNames){
            // BeanDefinition들의 이름을 통해  BeanDefinition 객체를 가져옴
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // 만약 이 BeanDefinition의 역할이 ROLE_APPLICATION이라면 출력
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = "+beanDefinitionName +
                        " beanDefinition = "+ beanDefinition);
            }
        }
    }
}
