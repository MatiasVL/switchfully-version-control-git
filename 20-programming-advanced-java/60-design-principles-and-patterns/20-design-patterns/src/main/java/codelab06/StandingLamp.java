package codelab06;

public class StandingLamp {

    public static void main(String[] args) {
        StandingLampChord standingLampChord = new StandingLampChord(0);

        System.out.println(standingLampChord.pullChord());
        System.out.println(standingLampChord.pullChord());
        System.out.println(standingLampChord.pullChord());
        System.out.println(standingLampChord.pullChord());
        System.out.println(standingLampChord.pullChord());
    }
}
