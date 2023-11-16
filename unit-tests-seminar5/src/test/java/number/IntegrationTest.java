package number;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;

public class IntegrationTest {
    public int size = 15;
    @Test
    void maxNumberIntegrationTest (){
        RandomNumberArrayModule arrayNumbers = new RandomNumberArrayModule();
        int []testArray = arrayNumbers.randomNumberArray(size);

        MaxNumberInArrayModule maxNumber = new MaxNumberInArrayModule();
        int max  = maxNumber.maxNumberInArray(testArray);

        Arrays.sort(testArray);
        assertThat(testArray[testArray.length-1]).isEqualTo(max);
    }
}
