package com.functionaljoo.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato
 */
public class Either2Test {

    public Either2Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldReturnD() {
        A a = new A();
        String result = Either2.options(a.getB(), a.getC())
                .foldOptional(l -> l, r -> r)
                .orElse("D");
        assertEquals("D", result);
    }

    @Test
    public void shouldReturnB() {
        A a = new A();
        a.setB("B");
        String result = Either2.options(a.getB(), a.getC())
                .foldOptional(l -> l, r -> r)
                .orElse("D");
        assertEquals("B", result);
    }

    static class A {

        private String b;
        private String c;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }

}
