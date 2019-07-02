package lambdas.code_example01_lambdas.v2_lambda;

public class Runner {

    public static void main(String[] args) {
        Text text = new Text("Hello bello world");
        text.printFilteredWords(word -> word.contains("e"));
    }

}
