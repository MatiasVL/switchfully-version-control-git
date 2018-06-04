import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringsCodelab03Test {

    @Test
    public void wrapWord() throws Exception {
        Assertions.assertThat(StringsCodelab03.wrapWord("xxxx", "oOo")).isEqualTo("xxoOoxx");
        Assertions.assertThat(StringsCodelab03.wrapWord("[[]]", "yo yo")).isEqualTo("[[yo yo]]");
        Assertions.assertThat(StringsCodelab03.wrapWord("<[x<>y]>", "yo yo")).isEqualTo("<[x<yo yo>y]>");
    }

}