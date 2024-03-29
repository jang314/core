package hello.aop.pointcut;

import hello.aop.order.aop.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Slf4j
@Import(AtAnnotaionTest.AtAnnotationAspect.class)
public class AtAnnotaionTest {
    @Autowired
    MemberService memberService;

    @Test
    void success() {
        log.info("ok");
    }

    @Slf4j
    @Aspect
    static class AtAnnotationAspect
    {
        @Around("@annotation(hello.aop.order.aop.member.annotation.MethodAop")
        public Object doAtAnnotation(ProceedingJoinPoint joinPoint)  throws Throwable{
            log.info("[@annotaion] {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }

    }
}
