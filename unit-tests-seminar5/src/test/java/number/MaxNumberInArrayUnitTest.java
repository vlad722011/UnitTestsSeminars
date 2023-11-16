package number;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class MaxNumberInArrayUnitTest {
    @Test
    void testMaxNumberInArray(){
        MaxNumberInArrayModule maxNumber = new MaxNumberInArrayModule();
        int[] testArray = new int[]{-4,323,53434,455,6,9};
        assertThat(maxNumber.maxNumberInArray(testArray)).isEqualTo(53434);
    }
}
