package mh.algorithms;

import java.util.Arrays;

public class MergeSort implements Sortable {

    @Override
    public void sort(Comparable[] array) {
        Comparable[] ArrayCopy = new Comparable[array.length];
        mergesort(array, ArrayCopy, 0, array.length - 1);
    }

    private void mergesort(Comparable[] array, Comparable[] arrayCopy, int low, int high) {

        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(array, arrayCopy, low, middle);
            // Sort the right side of the array
            mergesort(array, arrayCopy, middle + 1, high);
            // Combine them both
            merge(array, arrayCopy, low, middle, high);
        }
    }

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
        // Copy the rest of the left side of the array into the target array
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




