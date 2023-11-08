package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    // 3.1.
    SomeService service;
    @BeforeEach
    void setup() {
        service = new SomeService();
    }
    @ParameterizedTest
    @ValueSource(ints = {33, 6, 12, 3})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 25, 40})
    void multipleFiveNotThreeReturnsBuzz(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
    void multipleFifteenNotFiveNotThreeReturnsFizzBuzz(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 101})
    void multipleNotFifteenNotFiveNotThreeReturnsOriginNumber(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo(String.valueOf(n));
    }

    @Test
    void firstIsSix() {
        int[] arr = new int[]{6,1,2,3,4,5};
        assertThat(service.firstLast6(arr)).isTrue();
    }
    @Test
    void lastIsSix() {
        int[] arr = new int[]{1,2,3,4,5,6};
        assertThat(service.firstLast6(arr)).isTrue();
    }

    @Test
    void firstAndLastIsNoSix() {
        int[] arr = new int[]{1,2,3,4,5};
        assertThat(service.firstLast6(arr)).isFalse();
    }

    @Test
    void OneThirteenLuckySum() {
        assertThat(service.luckySum(13,5,4)).isEqualTo(9);
        assertThat(service.luckySum(5,13,4)).isEqualTo(9);
        assertThat(service.luckySum(4,5,13)).isEqualTo(9);

    }

    @Test
    void TwoThirteenLuckySum() {
        assertThat(service.luckySum(13,13,4)).isEqualTo(4);
        assertThat(service.luckySum(13,4,13)).isEqualTo(4);
        assertThat(service.luckySum(4,13,13)).isEqualTo(4);
    }

    @Test
    void ThreeThirteenLuckySum() {
        assertThat(service.luckySum(13,13,13)).isEqualTo(0);
    }

    @Test
    void normalLuckySum() {
        assertThat(service.luckySum(1,2,3)).isEqualTo(6);
    }
}