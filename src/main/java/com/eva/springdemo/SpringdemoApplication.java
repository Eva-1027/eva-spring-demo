package com.eva.springdemo;

import com.eva.springdemo.component.ApplicationAwareService;
import com.eva.springdemo.component.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringdemoApplication.class, args);
		//这里有一个小白猜测，启动项目以后spring的application整个是另外一个线程在跑。

		//Test lazy-init: in fact, the lazy-init won't use the cache in DefaultSingletonBeanRegistry.
		DemoService demoService = ApplicationAwareService.getAwareServiceApplicationContext().getBean(DemoService.class);
		System.out.println(demoService.hello());
	}

}
