package com.functionaljoo.base;

import java.util.function.Function;
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
    public void testBimapShouldReturnMapR() {
        Root root = new Root();
        root.setLeft(null);
        root.setRight("R");

        Either2<String, String> get = Either2.options(root.getLeft(), root.getRight()).get();

        System.out.println(get.left());

        String result = get
                .bimap(left -> "MapL", right -> "MapR")
                .foldOptional(left -> left, right -> right)
                .orElse("Else");

        assertEquals("MapR", result);
    }

    static class Root {

        private String left;
        private String right;

        public String getLeft() {
            return left;
        }

        public void setLeft(String left) {
            this.left = left;
        }

        public String getRight() {
            return right;
        }

        public void setRight(String right) {
            this.right = right;
        }
    }

}
