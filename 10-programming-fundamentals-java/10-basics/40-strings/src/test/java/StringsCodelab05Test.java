import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringsCodelab05Test {

    @Test
    public void replaceCharacter() throws Exception {
        Assertions.assertThat(StringsCodelab05.replaceCharacter("This text contains stuff", 't', 's'))
                .isEqualTo("shis sexs consains ssuff");
        Assertions.assertThat(StringsCodelab05.replaceCharacter("This text contains stuff", 't', 'S'))
                .isEqualTo("Shis SexS conSains sSuff");
        Assertions.assertThat(StringsCodelab05.replaceCharacter("This is an axe, Sweet HUH?", 's', 'L'))
                .isEqualTo("ThiL iL an axe, Lweet HUH?");
    }

}