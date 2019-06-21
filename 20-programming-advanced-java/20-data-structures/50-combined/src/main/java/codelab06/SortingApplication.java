package codelab06;

import codelab06.sorting.BubbleSort;
import codelab06.sorting.InsertionSort;
import codelab06.sorting.SelectionSort;
import codelab06.sorting.SortingAlgorithm;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingApplication {

    public static void main(String[] args) {
        List<Integer> numbersToSortSmall = List.of(5, 4, 8, 9, 1, 2, 8);
        List<Integer> numbersToSortLarge = GenerateRandomListOf(150000);

        SortingAlgorithm insertionSort = new InsertionSort();
        SortingAlgorithm selectionSort = new SelectionSort();
        SortingAlgorithm bubbleSort = new BubbleSort();

        System.out.println("Sort Small");
        System.out.println("\tInsertion sort result:");
        System.out.println("\t\t" + insertionSort.sort(numbersToSortSmall));
        System.out.println("\tSelection sort result:");
        System.out.println("\t\t" + selectionSort.sort(numbersToSortSmall));
        System.out.println("\tBubble sort result:");
        System.out.println("\t\t" + bubbleSort.sort(numbersToSortSmall));

        System.out.println("---------------");
        System.out.println("Sort Large");
        System.out.println("\tInsertion sort result (large):");
        System.out.println("\t\t" + insertionSort.sort(numbersToSortLarge));
        System.out.println("\tSelection sort result (large):");
        System.out.println("\t\t" + selectionSort.sort(numbersToSortLarge));
        System.out.println("\tBubble sort result (large):");
        System.out.println("\t\t" + bubbleSort.sort(numbersToSortLarge));
    }

    private static List<Integer> GenerateRandomListOf(int amountOfElement)
    {
        var randomNumber = new Random();
        return IntStream.range(0, amountOfElement)
                .map(i -> randomNumber.nextInt()).boxed()
                .collect(Collectors.toList());
    }
}
