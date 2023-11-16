package number;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class RandomNumberArrayUnitTest {
    public int sizeArray = 15;
    @Test
    void testRandomNumberArray() {
        RandomNumberArrayModule randomNumberArray = new RandomNumberArrayModule();
        int [] array = randomNumberArray.randomNumberArray(sizeArray);
        assertThat(array.length).isEqualTo(sizeArray);
    }
}