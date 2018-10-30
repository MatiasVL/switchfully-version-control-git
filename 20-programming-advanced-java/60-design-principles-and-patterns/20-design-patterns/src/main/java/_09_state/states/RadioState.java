package _09_state.states;

import _09_state.MP3Player;

public class RadioState implements State {

    @Override
    public void pressPlayButton(MP3Player context) {
        System.out.println("\tPressing the play button when in the radio state, will change the radio channel");
        System.out.println("\t\tThe radio state will remain the current state");
    }

    @Override
    public void pressToggleRadioButton(MP3Player context) {
        System.out.println("\tPressing the toggle radio button when in the radio state, will set the state to stand by");
        context.setToNewState(new StandByState());
    }
}
