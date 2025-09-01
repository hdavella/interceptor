package ar.com.servicioecu.interceptor.interceptor.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass()); //Puede ser tambien, GreetingAspect.class

    @Before("execution(* ar.com.servicioecu.interceptor.interceptor.*.*.*(..))")
    public void loggerBefore(JoinPoint beforeJoinPoint){

        String method= beforeJoinPoint.getSignature().getName();
        logger.info("Antes del metodo: " + method);
    }    
    
    @After("execution(* ar.com.servicioecu.interceptor.interceptor.*.*.*(..))")
    public void loggerAfter(JoinPoint beforeJoinPoint){
    
        String method= beforeJoinPoint.getSignature().getName();
        logger.info("Despues del metodo: " + method);
    }

}
