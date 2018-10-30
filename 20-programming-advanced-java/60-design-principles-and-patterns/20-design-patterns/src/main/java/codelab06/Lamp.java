package codelab06;

public class Lamp {

    private int currentState;

    public Lamp(int initialState) {
        this.currentState = initialState;
    }

    public String pullChord() {
        if (currentState == 0) {
            currentState = 1;
            return "dimmed light";
        } else if (currentState == 1) {
            currentState = 2;
            return "regular light";
        } else if (currentState == 2) {
            currentState = 3;
            return "bright light";
        } else if (currentState == 3) {
            currentState = 4;
            return "very bright light";
        } else {
            currentState = 0;
            return "turned off";
        }
    }

}
