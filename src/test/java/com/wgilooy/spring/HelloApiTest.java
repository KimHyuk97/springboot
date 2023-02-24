package com.wgilooy.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

    @Test
    void helloApi() {
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> test = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "test");
        // status code 200
        Assertions.assertThat(test.getStatusCode()).isEqualTo(HttpStatus.OK);
        // content-type text/plain
        Assertions.assertThat(test.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body
        Assertions.assertThat(test.getBody()).isEqualTo("Hello service test**");
    }

    @Test
    void failsHelloApi() {
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> test = rest.getForEntity("http://localhost:8080/hello?name=", String.class);
        // status code bad
        Assertions.assertThat(test.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
