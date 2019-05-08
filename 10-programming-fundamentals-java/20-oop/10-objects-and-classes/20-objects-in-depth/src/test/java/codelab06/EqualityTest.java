package codelab06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualityTest {

    @Test
    public void joinLorem_isCorrect() throws Exception {
        String[] lorem = {"Lorem","ipsum","dolor","sit","amet", "jotum"};
        String expected = "Lorem ipsum dolor sit amet jotum.";

        Assertions.assertThat(Equality.joinLorem(lorem))
                .describedAs("Lorem string objects should be equal.")
                .isEqualTo(expected);
    }

    @Test
    public void buildLorem_isCorrect() throws Exception {
        String[] lorem = {"Lorem","ipsum","dolor","sit","amet", "situm"};
        String expected = "Lorem ipsum dolor sit amet situm.";

        Assertions.assertThat(Equality.buildLorem(lorem))
                .describedAs("Lorem string objects should be equal.")
                .isEqualTo(expected);
    }

}
