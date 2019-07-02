package lambdas.code_example01_lambdas.v1_anonymous_class;

@FunctionalInterface
public interface WordFilter {
    boolean isValid(String word);
}

