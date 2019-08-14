package codeexamplesfromslides.multiplecatch;

public class MultipleCatch {

    public static void main(String[] args) {
        Object ok = "yes";
        Exception e = (Exception) ok;
//        example1(new int[5]);
//            example2(null);
            example3(10, 0);
    }

    private static int[] example1(int[] numbers) {
        try {
            numbers[6] = 13;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            System.err.println("One of two exceptions: "  + ex.getMessage());
        } catch (RuntimeException ex) {
            System.err.println("RuntimeException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        }
        return numbers;
    }

    private static String example2(String text) {
        try {
            text = text.concat("!!!");
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            System.err.println("One of two exceptions: "  + ex.getMessage());
        } catch (RuntimeException ex) {
            System.err.println("RuntimeException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        }
        return text;
    }

    private static int example3(int numerator, int denominator) {
        int result = 0;
        try {
            result = numerator / denominator;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            System.err.println("One of two exceptions: "  + ex.getMessage());
        }
        catch (RuntimeException ex) {
            System.err.println("RuntimeException: " + ex.getMessage());
        }
        return result;
    }


}
