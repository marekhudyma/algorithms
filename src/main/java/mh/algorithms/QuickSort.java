package mh.algorithms;

import java.util.Arrays;

/**
 * Quicksort, or partition-exchange sort, is a sorting algorithm developed by Tony Hoare that, on average,
 * makes O(n log n) comparisons to sort n items. In the worst case, it makes O(n2) comparisons,
 * though this behavior is rare. Quicksort is often faster in practice than other O(n log n) algorithms
 *
 * complexity O(n * log n)
 * memory O(1)
 */
public class QuickSort implements Sortable {

    @Override
    public void sort(Comparable[] array) {
       quicksort(array, 0, array.length -1);
    }

    /**
     * method sort elements in array
     * @param array
     * @param left index of left border (included)
     * @param right index of right border (included)
     */
    private void quicksort(final Comparable[] array, final int left, final int right) {
        if(left < right) {
            int pivotIndex = partition(array, left, right);
            quicksort(array, left, pivotIndex-1);
            quicksort(array, pivotIndex+1, right);
        }
    }

    /**
     * method take the first element as pivot, and put elements smaller elements to one side,
     * bigger to other side
     * @param array
     * @return
     */
    public int partition(final Comparable[] array, final int left, final int right) {
        Comparable pivotElement = array[left];
        array[left] = Integer.MAX_VALUE;

        int whereIsEmptyElement = -1; //-1=right, 1=left
        int l = left+1;
        int r = right;
        while(l < r+1) {

            if(whereIsEmptyElement == -1) { //left
                if(pivotElement.compareTo(array[r])>0) {
                    swap(array, l-1, r);
                    whereIsEmptyElement = 1;
                }
                r--;
            } else {
                if(pivotElement.compareTo(array[l])<0) {
                    swap(array, l, r+1);
                    whereIsEmptyElement = -1;
                }
                l++;
            }
        }
        int pivotIndex = -1;
        if(whereIsEmptyElement == -1) {
            pivotIndex = l - 1;
        } else {
            pivotIndex = r + 1;
        }
        array[pivotIndex] = pivotElement;
        return pivotIndex;
    }

    /**
     * replace 2 elements in the array
     * @param array
     * @param index1
     * @param index2
     */
    private void swap(final Comparable[] array, final int index1, final int index2) {
        Comparable c = array[index1];
        array[index1] = array[index2];
        array[index2] = c;
    }
}
