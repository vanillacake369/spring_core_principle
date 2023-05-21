package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 해당 패키지에서만 컴포넌트를 찾음 :: 탐색 시간을 줄일 수 있음
        basePackages = "hello.core",
        // 실무에서는 exclude 잘 하진 않음
        // Configuration 어노테이션을 수동으로 해놓은 Config클래스는 제외!
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {
}
