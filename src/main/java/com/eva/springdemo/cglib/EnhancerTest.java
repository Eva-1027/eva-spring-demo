package com.eva.springdemo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerTest {

    //To avoid error, should add VM options: --add-opens java.base/java.lang=ALL-UNNAMED
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EchoService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("[Cglib echo]: " + objects[0]);
                //method.invoke(o, objects);
                methodProxy.invokeSuper(o, objects);
                return o;
            }
        });
        EchoService echoServiceProxy = (EchoService) enhancer.create();
        echoServiceProxy.echo("Eva got the job smoothly!^_^");
    }
}
