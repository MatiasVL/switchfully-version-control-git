package codelab03;

/**
 * Read the README.md file
 */
public class MyOwnLocalDate {

    private int year;
    private int month;
    private int dayOfMonth;

    static final int MAX_YEAR = 2100;
    static final int MIN_YEAR = 1901;

    /*
     * By setting the only constructor of MyOwnLocalDate to private,
     * we made it impossible for other classes to create an object
     * of MyOwnLocalDate using the new keyword.
     */
    private MyOwnLocalDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    /*
     * To create an object, other classes
     * can use this class method (static method)
     */
    static MyOwnLocalDate create(int year, int month, int dayOfMonth) {
        int validatedYear = validateYear(year);
        int validatedMonth = validateMonth(month);
        int validateDayOfMonth = validateDayOfMonth(dayOfMonth);
        return new MyOwnLocalDate(validatedYear, validatedMonth, validateDayOfMonth);
    }

    private static int validateYear(int year) {
        return -1; // implement me properly!
    }

    private static int validateMonth(int month) {
        return -1; // implement me properly!
    }

    private static int validateDayOfMonth(int dayOfMonth) {
        return -1; // implement me properly!
    }

    @Override
    public String toString() {
        return  dayOfMonth + "/" + month + "/" + year;
    }
}
