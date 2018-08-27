package _09_state.states;

import _09_state.MP3Player;

public class PlayingState implements State {

    @Override
    public void pressPlayButton(MP3Player context) {
        System.out.println("\tPressing the play button when in the playing state, will set the state to stand by");
        context.setToNewState(new StandByState());
    }

    @Override
    public void pressToggleRadioButton(MP3Player context) {
        System.out.println("\tPressing the toggle radio button when in the playing state, will set the state to radio");
        context.setToNewState(new RadioState());
    }
}
