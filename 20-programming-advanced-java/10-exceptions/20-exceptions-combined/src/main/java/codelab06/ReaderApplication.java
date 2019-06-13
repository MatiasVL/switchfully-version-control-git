package codelab06;

public class ReaderApplication {

    public static void main(String[] args) {

        MyFileReader myFileReader = new MyFileReader();
        myFileReader.read("example.txt");
            System.out.println("========================");
        myFileReader.read("scores.csv");

    }

}
