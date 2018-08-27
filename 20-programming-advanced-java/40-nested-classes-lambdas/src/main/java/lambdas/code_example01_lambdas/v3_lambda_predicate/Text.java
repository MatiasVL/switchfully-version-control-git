package lambdas.code_example01_lambdas.v3_lambda_predicate;

import java.util.function.Predicate;

public class Text{
    private String sentence;

        public Text(String sentence) {
            this.sentence = sentence;
        }

            public void printFilteredWords(Predicate<String> filter){
            for (String word: sentence.split(" ")){
                if (filter.test(word)){
                    System.out.println(word);
                }
            }
        }
}

