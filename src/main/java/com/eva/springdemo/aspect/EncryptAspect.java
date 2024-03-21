package com.eva.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;

@Component
@Aspect
public class EncryptAspect {

    @Pointcut("@annotation(com.eva.springdemo.aspect.Encryption)")
    //切点表达式，定义了切面将在何处被应用。可以看做连接点的集合。
    private void encryptMethods() {}

    @After("encryptMethods()")
    //根据 Spring AOP 的设计原则，After Advice 不应该有返回值，而应该专注于执行一些后置逻辑。
    public void afterReturnString(JoinPoint joinPoint) throws NoSuchAlgorithmException {
        //连接点是代码执行过程中可以插入切面的具体点。

        //获取连接点的方法名，类名和参数。
        Signature signature = joinPoint.getSignature();
        System.out.println("joinPoint Signature method name is : " + signature.getName());
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        //如果注解是带参数的，如何获取注解参数中的值？
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Encryption anno = method.getAnnotation(Encryption.class);
        String annoValue = anno.value();
        System.out.println("Value in annotation config is: " + annoValue);
    }

}
