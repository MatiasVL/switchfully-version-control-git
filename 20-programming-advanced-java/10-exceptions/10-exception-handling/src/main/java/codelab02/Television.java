package codelab02;

/**
 * You don't have to change anything in this class.
 */
public class Television {

    private static final int TOP_CHANNEL = 50;
    private static final int BOTTOM_CHANNEL = 0;

    private boolean isTurnedOn;
    private boolean isPluggedIn;
    private int currentChannel;

    public Television() {
        isTurnedOn = false;
        isPluggedIn = false;
        currentChannel = -1;
    }

    public void turnOn() {
        if(!isPluggedIn) {
            throw new IllegalStateException("Can't turn on TV if it's not plugged in!");
        }
        isTurnedOn = true;
    }

    public void plugIn() {
        isPluggedIn = true;
    }

    public void switchChannelTo(int newChannel) {
        if(!isTurnedOn) {
            throw new IllegalStateException("Can't set the channel if the TV is not turned on!");
        }
        if(newChannel > TOP_CHANNEL || newChannel < BOTTOM_CHANNEL) {
            throw new IllegalArgumentException("The provided channel of " + newChannel + " is not valid. The channel " +
                    "needs to be between (both including) " + TOP_CHANNEL + " and " + BOTTOM_CHANNEL);
        }
        this.currentChannel = newChannel;
    }

    @Override
    public String toString() {
        return "Television{" +
                "isTurnedOn=" + isTurnedOn +
                ", isPluggedIn=" + isPluggedIn +
                ", currentChannel=" + currentChannel +
                '}';
    }
}
