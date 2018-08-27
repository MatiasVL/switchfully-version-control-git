package extra_exercises.codelab01;

import extra_exercises.codelab01.sorting.BubbleSort;
import extra_exercises.codelab01.sorting.InsertionSort;
import extra_exercises.codelab01.sorting.SelectionSort;
import extra_exercises.codelab01.sorting.SortingAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Don't modify this code!
 * Do run this code. :)
 */
public class SortingApplication {

    public static void main(String[] args) {

        List<Integer> numbersToSortSmall = Arrays.asList(5,4,8,9,1,2,8);
        List<Integer> numbersToSortLarge = generateRandomListOf(150000);

        System.out.println(numbersToSortLarge);

        SortingAlgorithm insertionSort = new InsertionSort();
        SortingAlgorithm selectionSort = new SelectionSort();
        SortingAlgorithm bubbleSort = new BubbleSort();

        System.out.println("Sort Small");
        System.out.print("\tInsertion sort result:");
        System.out.print("\t\t" + insertionSort.sort(numbersToSortSmall));
        System.out.print("\tSelection sort result:");
        System.out.print("\t\t" + selectionSort.sort(numbersToSortSmall));
        System.out.print("\tBubble sort result:");
        System.out.print("\t\t" + bubbleSort.sort(numbersToSortSmall));

        System.out.println("---------------");
        System.out.println("Sort Large");
        System.out.print("\tInsertion sort result:");
        System.out.print("\t\t" + insertionSort.sort(numbersToSortLarge));
        System.out.print("\tSelection sort result:");
        System.out.print("\t\t" + selectionSort.sort(numbersToSortLarge));
        System.out.print("\tBubble sort result:");
        System.out.print("\t\t" + bubbleSort.sort(numbersToSortLarge));

    }
    private static List<Integer> generateRandomListOf(int amountOfElement) {
        return IntStream.generate(() -> (int) (Math.random() * amountOfElement))
                .limit(amountOfElement)
                .boxed()
                .collect(toList());
    }

}
