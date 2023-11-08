package seminars.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.calculator.Calculator;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CalculationTest {
    private Calculator calculator;

    @BeforeEach
    void setup(){
        Calculator calculator = new Calculator();
    }
    @Test
    void additionExpressionEvaluation() {
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void subtractionExpressionEvaluation() {
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
    }

    @Test
    void multiplicationExpressionEvaluation() {
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
    }

    @Test
    void divisionExpressionEvaluation() {
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol() {
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);
    }


    /**
     * Попробуйте реализовать в калькуляторе с помощью методологии TDD (с описанием
     * шагов) функцию расчета длины окружности
     */
    @Test
    void computeLengthCircle(){
        assertThat(Calculator.computeLengthCircle(10)).isEqualTo(62.83185307179586);
    }
}
