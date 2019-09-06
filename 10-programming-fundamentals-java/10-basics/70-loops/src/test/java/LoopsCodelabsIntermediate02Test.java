import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LoopsCodelabsIntermediate02Test {

    @Test
    void negativeNumber() {
        Assertions.assertThat(LoopsCodelabsIntermediate02.createRange(-15)).isEqualTo(new int[]{});
    }

    @Test
    void zero() {
        Assertions.assertThat(LoopsCodelabsIntermediate02.createRange(0)).isEqualTo(new int[]{});
    }

    @Test
    void simpleArray() {
        Assertions.assertThat(LoopsCodelabsIntermediate02.createRange(1)).isEqualTo(new int[]{1});
    }

    @Test
    void LongArray() {
        Assertions.assertThat(LoopsCodelabsIntermediate02.createRange(10)).isEqualTo(new int[]{1,2,3,4,5,6,7,8,9,10});
    }
}