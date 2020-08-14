package com.gec.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {

    @Before(value = "execution(* com.gec.impl.*.select*(..))")
    public void beforeSelect(){
        System.out.println("开始查询....");
    }

    @Before(value = "execution(* com.gec.impl.*.update*(..))")
    public void beforeUpdate(){
        System.out.println("开启更新事务....");
    }

    @Before(value = "execution(* com.gec.impl.*.delete*(..))")
    public void beforeDelete(){
        System.out.println("开启删除事务....");
    }

    @Before(value = "execution(* com.gec.impl.*.insert*(..))")
    public void beforeInsert(){
        System.out.println("开启插入事务....");
    }

    @AfterReturning(value = "execution(* com.gec.impl.*.update*(..))")
    public void afterReturning(){
        System.out.println("提交事务。。。。");
    }

    @Around(value = "execution(* com.gec.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知前....");
        Object proceed = pjp.proceed();
        System.out.println("环绕通知后....");
        return proceed;
    }

    @AfterThrowing(value = "execution(* com.gec.impl.*.*(..))")
    public void afterException(){
        System.out.println("出现异常！！！！");
    }

    @After(value = "execution(* com.gec.impl.*.*(..))")
    public void after(){
        System.out.println("结束。");
    }
}
