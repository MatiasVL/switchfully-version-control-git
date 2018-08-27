# Sorting

We're going to write our own sorting algorithms.
Implement the Insertion, Selection and Bubble sort algorithms

1. Write tests (they should be easy to write)
2. Don't change to SortingApplication class

## Selection sort

Flow:
1. Find the smallest number. Swap it with the first number.
2. Find the second-smallest number. Swap it with the second number.
3. Find the third-smallest number. Swap it with the third number.
4. Repeat finding the next-smallest number, and swapping it into the correct position until the array is sorted.

- When is selection sort efficient?
- When is selection sort less efficient?

## Insertion sort

Flow:
```
i ← 1
while i < length(A)
    j ← i
    while j > 0 and A[j-1] > A[j]
        swap A[j] and A[j-1]
        j ← j - 1
    end while
    i ← i + 1
end while
```
Where i = index and A = the list to sort

- When is insertion sort efficient?
- When is insertion sort less efficient?

## Bubble sort

Flow:
```
n = length(A)
    repeat 
        swapped = false
        for i = 1 to n-1 inclusive do
            /* if this pair is out of order */
            if A[i-1] > A[i] then
                /* swap them and remember something changed */
                swap( A[i-1], A[i] )
                swapped = true
            end if
        end for
    until not swapped
```
Where A = the list to sort

- When is bubble sort efficient?
- When is bubble sort less efficient?