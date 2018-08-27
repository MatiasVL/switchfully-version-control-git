package codelab06;

/**
 * The chord of a standing lamp
 * which is to be used to control the lamp
 */
class StandingLampChord {

    private int currentState;

    StandingLampChord(int initialState) {
        this.currentState = initialState;
    }

    String pullChord() {
        if (currentState == 0) {
            currentState = 1;
            return "dimmed light";
        } else if (currentState == 1) {
            currentState = 2;
            return "regular light";
        } else if (currentState == 2) {
            currentState = 3;
            return "bright light";
        } else {
            currentState = 0;
            return "turned off";
        }
    }
}
