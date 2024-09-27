package com.oseanchen.demotest.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void initCalculator() {
        System.out.println("-----每個項目執行前我都執行一次 @BeforeEach-----");
        calc = new Calculator();
    }

    @AfterEach
    void tearDownCalculator() {
        System.out.println("-----每個項目執行完我都執行一次 @AfterEach-----");
        calc = null;
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("=====全部開始前是我 @BeforeAll=====");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("=====全部結束後是我 @AfterAll=====");
    }

    @Test
    @DisplayName("加法測試")
    public void testAdd() {
        System.out.println("執行 testAdd()");
        int result = calc.add(1, 1);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("減法測試")
    public void testSubtract() {
        System.out.println("執行 testSubtract()");
        int result = calc.subtract(3, 1);
        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        System.out.println("執行 testMultiply()");
        int result = calc.multiply(3, 2);
        assertEquals(6, result);
    }

    @Test
    @Disabled
    public void testDivide() {
        System.out.println("執行 testDivide()");
        int result = calc.divide(2, 2);
        assertEquals(1, result, "result should be 1");
        assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(2, 0);
        });
    }
}