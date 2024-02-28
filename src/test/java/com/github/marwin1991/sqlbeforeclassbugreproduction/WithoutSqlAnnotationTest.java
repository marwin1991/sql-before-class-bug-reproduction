package com.github.marwin1991.sqlbeforeclassbugreproduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

@SpringBootTest
public class WithoutSqlAnnotationTest {

    private static int var = 0;


    @BeforeAll
    public static void init(){
        System.out.println("Calling init method");

        var = 1;

        // init here mock server f.e
        // mockWebServer = new MockWebServer();
        // mockWebServer.start();
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        System.out.println("Calling properties method");

        registry.add("test", () -> "1");
        var = 2;

        // add port here to properties
        // registry.add("port", () -> mockWebServer.getPort());
    }

    @Test
    void varShouldBeEqualTo1(){
        Assertions.assertEquals(2, var);
    }
}
