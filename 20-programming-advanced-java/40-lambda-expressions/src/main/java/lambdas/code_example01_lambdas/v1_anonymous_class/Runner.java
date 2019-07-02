package lambdas.code_example01_lambdas.v1_anonymous_class;

public class Runner {

    public static void main(String[] args) {
        Text text = new Text("Hello bello world");

        text.printFilteredWords(new WordFilter() {
            public boolean isValid(String word) {
                return word.contains("e");
            }
        });

    }

}
