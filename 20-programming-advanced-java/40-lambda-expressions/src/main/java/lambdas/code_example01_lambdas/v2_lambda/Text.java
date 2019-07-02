package lambdas.code_example01_lambdas.v2_lambda;

public class Text{
    private String sentence;

        public Text(String sentence) {
            this.sentence = sentence;
        }

            public void printFilteredWords(WordFilter filter){
            for (String word: sentence.split(" ")){
                if (filter.isValid(word)){
                    System.out.println(word);
                }
            }
        }
}

