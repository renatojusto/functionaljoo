package com.functionaljoo.base;

import com.functionaljoo.base.Either2;
import com.functionaljoo.base.EitherOptional;
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
public class EitherOptionalTest {

    public EitherOptionalTest() {
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

    /**
     * Test of of method, of class EitherOr.
     */
    @Test
    public void testOf() {
    }

    /**
     * Test of or method, of class EitherOr.
     */
    @Test
    public void deveRetornarC() {
        // String result = EitherOr.of(1, "B").<String>toOptional().orElse("C");
        String a = null;
        String b = null;
        String result2 = EitherOptional.options(a, b)
                .fold(l -> l.get(), r -> r.get())
                .orElse("C");

        assertEquals("C", result2);
    }

    @Test
    public void deveRetornarD() {
        // String result = EitherOr.of(1, "B").<String>toOptional().orElse("C");
        String a = null;
        String b = null;
//        String result2 = Either2.options(a, b)
//                .foldOptional(l -> l, r -> r)
//                .orElse("D");
//
//        String result3 = Either2.options(a, "R").fold(l -> l, r -> "D");
//
//        Either2.options(a, b)
//                .flatBimap(EitherOptionalTest::format, EitherOptionalTest::format);

//        String result4 = Either2.options(a, "R")
//                .flatMapRight(f -> "D")
//                .fold(l -> l, r -> r);
//
//        Optional.ofNullable("").flatMap(f -> "D");

//        assertEquals("D", result2);
//        assertEquals("D", result3);
    }

    public static String format(String v) {
        return "F";
    }

    @Test
    public void deveRetornarC2() {
        // String result = EitherOr.of(1, "B").<String>toOptional().orElse("C");
        String a = null;
        String b = null;
        // String result2 = EitherOptional.options(a, b);
//                .flatMap(l, r -> );
        // Either.left("").

        // assertEquals("C2", "");

//            Either<String, String> aOrB = Option
//                    .option(cliente.get().getCpf())
//                    .toLeft(() -> cliente.get().getCnpj());
//            aOrB.fold(Util::formatarCpf, Util::formatarCnpj);
//
//            cliente.map(Cliente::getCpf).map(Util::formatarCpfCnpj).orElse(null);
//            cliente.map(Cliente::getCnpj).map(Util::formatarCnpj).orElse(null);

//            EitherOptional.options(cliente.get().getCpf(), cliente.get().getCnpj())
//                    .fold(cpf -> cpf.get(), cnpj -> cnpj.get())
//                    .map(Util::formatarCpfCnpj)
//                    .orElse("");
    }

}
