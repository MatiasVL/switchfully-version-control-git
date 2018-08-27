package _09_state;

import _09_state.states.PlayingState;

public class MusicDeviceApplication {

    public static void main(String[] args) {

        MP3Player mp3Player = new MP3Player(new PlayingState());

        System.out.println("Pressing 2 times on the play button when the MP3 player is already playing a song");
        mp3Player.play();
        mp3Player.play();

        System.out.println("Switching to Radio and pressing some buttons");
        mp3Player.toggleRadioMode();
        mp3Player.play();
        mp3Player.play();
        mp3Player.toggleRadioMode();
        mp3Player.play();

    }

}
