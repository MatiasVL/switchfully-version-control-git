package codelab01;

public class Train {

    private int hoursDelayed;

    public Train() {
    }

    public int getHoursDelayed() {
        return hoursDelayed;
    }

    public void setHoursDelayed(int hoursDelayed) {
        if (hoursDelayed < 0) {
            this.hoursDelayed = 0;
        } else {
            this.hoursDelayed = hoursDelayed;
        }
    }

    public String customerSatisfaction() {
        return "Nice ‘n’ rolling!";
    }
}
