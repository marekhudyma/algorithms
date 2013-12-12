package mh.algorithms;

/**
 * http://en.wikipedia.org/wiki/Bubble_sort
 *
 * a simple sorting algorithm that works by repeatedly stepping through the list to be sorted,
 * comparing each pair of adjacent items and swapping them if they are in the wrong order.
 * The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted
 *
 * complexity O(x^2)
 * memory O(1)
 */
public class BubbleSort implements Sortable {

    public void sort(final Comparable[] array) {
        if(array == null) {
            throw new NullPointerException("array cannot be null");
        }
        boolean shouldIterate = true;
        while (shouldIterate){
            shouldIterate = false;
            for(int j=0; j<array.length-1; j++){
                if(array[j].compareTo(array[j+1]) > 0) {
                    Comparable temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    shouldIterate = true;
                }
            }
        }
    }


}
