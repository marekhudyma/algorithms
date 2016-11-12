package mh.algorithms;

import java.util.Arrays;

/**
 * http://en.wikipedia.org/wiki/Merge_sort
 *
 * Mergesort is a divide and conquer algorithm
 *
 * complexity O(n * log n)
 * memory 2xO(1)
 */
public class MergeSort implements Sortable {

    @Override
    public void sort(Comparable[] array) {
        //use copy of array
        Comparable[] ArrayCopy = new Comparable[array.length];
        mergesort(array, ArrayCopy, 0, array.length - 1);
    }

    private void mergesort(Comparable[] array, Comparable[] arrayCopy, int low, int high) {
        //check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            //get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            //sort the left side of the array
            mergesort(array, arrayCopy, low, middle);
            //sort the right side of the array
            mergesort(array, arrayCopy, middle + 1, high);
            //merge
            merge(array, arrayCopy, low, middle, high);
        }
    }

    /**
     * merge two parts of "devided" array
     * one: from low (included) to middle (included)
     * second: from middle+1 to hight (included)
     * @param array
     * @param arrayCopy
     * @param low index of left border (included)
     * @param middle index of the border (where array is "devided"
     * @param high index of right border (included)
     */
    private void merge(final Comparable[] array, final Comparable[] arrayCopy, final int low, final int middle, final int high) {
        int leftIndex = low;
        int rightIndex = middle + 1;

        int i=0;
        while (leftIndex <= middle && rightIndex <= high) {
            if (array[leftIndex].compareTo(array[rightIndex]) < 0) {
                arrayCopy[i] = array[leftIndex];
                leftIndex++;
            } else {
                arrayCopy[i] = array[rightIndex];
                rightIndex++;
            }
            i++;
        }
        //copy the rest of the left side of the array into the target array
        while (leftIndex <= middle) {
            arrayCopy[i] = array[leftIndex];
            leftIndex++;
            i++;
        }

        while (rightIndex <= high) {
            arrayCopy[i] = array[rightIndex];
            rightIndex++;
            i++;
        }

        leftIndex = low;
        for(int t=0; t<i; t++) {
            array[leftIndex] = arrayCopy[t];
            leftIndex++;
        }

    }
}




