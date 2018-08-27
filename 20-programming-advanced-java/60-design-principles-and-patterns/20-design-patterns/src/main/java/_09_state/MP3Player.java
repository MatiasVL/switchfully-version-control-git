package _09_state;

import _09_state.states.State;

public class MP3Player {

    private State currentState;

    public MP3Player(State currentState) {
        this.currentState = currentState;
    }

    public void play() {
        currentState.pressPlayButton(this);
    }

    public void toggleRadioMode() {
        currentState.pressToggleRadioButton(this);
    }

    public MP3Player setToNewState(State currentState) {
        this.currentState = currentState;
        return this;
    }

    public State getCurrentState() {
        return currentState;
    }
}
