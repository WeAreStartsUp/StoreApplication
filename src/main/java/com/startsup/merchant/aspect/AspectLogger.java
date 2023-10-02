package com.startsup.merchant.aspect;


import com.startsup.merchant.entities.Merchants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectLogger {
    private final Logger logger = LoggerFactory.getLogger(AspectLogger.class);

    @Before("execution(* fetchAllMerchants())")
    public void beforeController(JoinPoint joinPoint) {
        logger.info("calling fetchAllMerchants()");
    }
}
