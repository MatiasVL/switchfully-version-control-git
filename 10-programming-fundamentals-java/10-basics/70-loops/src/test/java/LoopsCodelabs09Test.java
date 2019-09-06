import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LoopsCodelabs09Test {

    @Test
    void negativeOrZeroNumber() {
        Assertions.assertThat(LoopsCodelabs09.fibonaci(-5)).isEqualTo(0);
        Assertions.assertThat(LoopsCodelabs09.fibonaci(0)).isEqualTo(0);
    }

    @Test
    void checkFibonaci() {
        Assertions.assertThat(LoopsCodelabs09.fibonaci(1)).isEqualTo(1);
        Assertions.assertThat(LoopsCodelabs09.fibonaci(2)).isEqualTo(1);
        Assertions.assertThat(LoopsCodelabs09.fibonaci(5)).isEqualTo(5);
        Assertions.assertThat(LoopsCodelabs09.fibonaci(8)).isEqualTo(21);
        Assertions.assertThat(LoopsCodelabs09.fibonaci(20)).isEqualTo(6765);
    }
}