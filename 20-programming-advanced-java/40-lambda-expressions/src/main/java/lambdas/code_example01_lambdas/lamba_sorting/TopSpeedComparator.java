package lambdas.code_example01_lambdas.lamba_sorting;

import java.util.Comparator;

public class TopSpeedComparator implements Comparator<Horse> {

    @Override
    public int compare(Horse h1, Horse h2) {
        return Float.compare(h1.getSpeedKmh(), h2.getSpeedKmh());
    }
}
