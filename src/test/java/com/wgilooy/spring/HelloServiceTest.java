package com.wgilooy.spring;

import com.wgilooy.spring.hello.HelloDecorator;
import com.wgilooy.spring.hello.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void test() {
        SimpleHelloService service = new SimpleHelloService();
        String test = service.sayHello("test");
        Assertions.assertThat(test).isEqualTo("Hello service test");
    }

    @Test
    void decoratorTest() {
        HelloDecorator decorator = new HelloDecorator(name -> name);
        String test = decorator.sayHello("test");
        Assertions.assertThat(test).isEqualTo("test**");
    }
}
