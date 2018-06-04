package _09_state.states;

import _09_state.MP3Player;

public class StandByState implements State {

    @Override
    public void pressPlayButton(MP3Player context) {
        System.out.println("\tPressing the play button when in the stand by state, will set the state to playing");
        context.setToNewState(new PlayingState());
    }

    @Override
    public void pressToggleRadioButton(MP3Player context) {
        System.out.println("\tPressing the toggle radio button when in the stand by state, will set the state to radio");
        context.setToNewState(new RadioState());
    }
}
