package codelab00;

public class BoxRunner {

    public static void main(String[] args) {

        Box whatsInTheBox1 = new Box();
        whatsInTheBox1.store("Some simple text");
        String contentOfBox1 = (String) whatsInTheBox1.getContentOfBox();
        System.out.println(String.format("First content of Box: %s", contentOfBox1));

        Box whatsInTheBox2 = new Box();
        whatsInTheBox2.store(15);
        Integer contentOfBox2 = (Integer) whatsInTheBox2.getContentOfBox();
        System.out.println(String.format("Second content of Box: %s", contentOfBox2));

        Box whatsInTheBox3 = new Box();
        whatsInTheBox3.store("Again some simple text");
        Integer contentOfBox3 = (Integer) whatsInTheBox3.getContentOfBox(); // This will go wrong at runtime!

    }

}
