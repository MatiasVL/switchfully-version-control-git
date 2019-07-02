package lambdas.code_example01_lambdas.lamba_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingApplication {

    public static void main(String[] args) {

        List<Horse> horses = Arrays.asList(
                new Horse("Devon", 5, 85.5f),
                new Horse("Dash", 4, 90.25f),
                new Horse("Albert", 9, 50f),
                new Horse("Burdy", 3, 86.21f)
        );

        horses.sort(new TopSpeedComparator());

        for (var horse: horses) {
            System.out.println(horse);
        }

        horses.sort(new Comparator<Horse>() {
            @Override
            public int compare(Horse h1, Horse h2) {
                return Float.compare(h1.getSpeedKmh(), h2.getSpeedKmh());
            }
        });

        for (var horse: horses) {
            System.out.println(horse);
        }

        horses.sort((h1, h2) -> Float.compare(h1.getSpeedKmh(), h2.getSpeedKmh()));

        for (var horse: horses) {
            System.out.println(horse);
        }

        int hello = 5;

        horses.sort((h1, h2) -> Integer.compare(h1.getAge(), h2.getAge()));

        for (var horse: horses) {
            System.out.println(horse);
        }
    }

}
