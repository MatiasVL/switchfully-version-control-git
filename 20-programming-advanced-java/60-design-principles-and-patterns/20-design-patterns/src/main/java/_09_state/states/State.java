package _09_state.states;

import _09_state.MP3Player;

public interface State {

    void pressPlayButton(MP3Player context);
    void pressToggleRadioButton(MP3Player context);

}
