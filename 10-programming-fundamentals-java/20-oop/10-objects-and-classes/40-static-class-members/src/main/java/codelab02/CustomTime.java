package codelab02;

/**
 * Not yet finished with codelab01?
 * Then quickly go back to codelab01, don't even look at this exercise :)
 *
 * Run the tests.
 * Remove the existing equals method.
 *      Go to menu Code > Generate, pick equals() and hashCode(). Hit next a few times (the defaults are fine).
 *      You can ignore the hashCode() function for now.
 * Study the generated equals method and explain to someone else what it does.
 * Run the tests again, they should all be green
 *
 * Change the add(Time other) method so that it becomes a pure method!
 *      Hint: No idea on what pure and impure methods are? Read the pure.md file!
 *
 * Review the documentation of java.awt.Rectangle.
 *      Find a method which is pure? Find one which is a modifier (impure)?
 *      Discuss with someone!
 *
 * Review the documentation of java.lang.String.
 *      Why can we say String is an immutable class (tip: look at the class definition)?
 *      Discuss with someone!
 *
 */
public class CustomTime {

    public static final CustomTime MIDNIGHT = new CustomTime(0, 0, 0);
    public static final CustomTime NOON = new CustomTime(12, 0, 0);

    private int hour;
    private int minute;
    private double second;

    public CustomTime() {
        this(0, 0, 0.0);
    }

    public CustomTime(int hour, int minute) {
        this(hour, minute, 0.0);
    }

    public CustomTime(int hour, int minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String toString() {
        return String.format("%02d:%02d:%04.1f",
                this.hour, this.minute, this.second);
    }

    public boolean equals(CustomTime that) {
        return this.hour == that.hour
                && this.minute == that.minute
                && this.second == that.second;
    }

    public void add(CustomTime other) {
        double secondSum = this.second + other.second;
        int addMinutes = (int) secondSum / 60;
        this.second = secondSum % 60;

        int minuteSum = this.minute + other.minute + addMinutes;
        int addHours = minuteSum / 60;
        this.minute = minuteSum % 60;

        int hourSum = this.hour + other.hour + addHours;
        this.hour = hourSum % 24;
    }

}
