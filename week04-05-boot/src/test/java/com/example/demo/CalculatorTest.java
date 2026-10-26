package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("1 더하기 2는 3이다")
    void additionTest() {
        // Given
        int a = 1;
        int b = 2;

        // When
        int result = calc.add(a, b);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("음수끼리 더하면 음수가 나온다")
    void addNegative() {
        assertThat(calc.add(-3, -5)).isEqualTo(-8);
    }

    @Test
    @DisplayName("0을 더하면 값이 그대로다")
    void addZero() {
        assertThat(calc.add(7, 0)).isEqualTo(7);
    }

    @Test
    @DisplayName("int 최댓값에 1을 더하면 오버플로우로 최솟값이 된다")
    void addOverflow() {
        assertThat(calc.add(Integer.MAX_VALUE, 1)).isEqualTo(Integer.MIN_VALUE);
    }
}