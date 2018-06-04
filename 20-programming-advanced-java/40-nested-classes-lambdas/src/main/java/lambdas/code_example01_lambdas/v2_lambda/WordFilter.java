package lambdas.code_example01_lambdas.v2_lambda;

@FunctionalInterface
public interface WordFilter {
    boolean isValid(String word);
}

