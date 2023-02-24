package com.wgilooy.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    @Test
    void helloControllerTest() {
        HelloController controller = new HelloController(name -> name);

        String rst = controller.hello("Test");

        Assertions.assertThat(rst).isEqualTo("Test");
    }

    @Test
    void failsHelloControllerTest() {
        HelloController controller = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            controller.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            controller.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
