package mh.algorithms;

/**
 * http://en.wikipedia.org/wiki/Insertion_sort
 *
 * a simple sorting algorithm that builds the final sorted array (or list) one item at a time
 *
 * complexity O(x^2)
 * memory O(1)
 *
 * iterating from right side to left and insert element if order is wrong
 */
public class InsertionSort implements Sortable {

    @Override
    public void sort(Comparable[] array) {

        // iterate through array
        for(int j=array.length-2; j>=0; j--) {
            Comparable currentElement = array[j];
            int index = indexOfElementSmallerThanValueFromRightSide(array, j, currentElement);
            if(index > 0) {
                moveArrayOneLeft(array, j+1, index);
                array[index] = currentElement;
            }
        }
        System.out.println("");
    }

    /**
     * method iterate from end of array (included) to indexFrom (included)
     * and return index of first smaller element
     * or return -1 if not found
     * @param array
     * @param indexFrom
     * @param value
     * @return index of smaller element from the right side or -1
     */
    private int indexOfElementSmallerThanValueFromRightSide(Comparable[] array, int indexFrom, Comparable value) {
        for(int i=array.length-1; i>=indexFrom; i--) {
            if(array[i].compareTo(value) < 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * move array elements one left from indexStart (included) to indexEnd (included)
     * @param array
     * @param indexStart
     * @param indexEnd
     */
    private void moveArrayOneLeft(Comparable[] array, int indexStart, int indexEnd) {
        for(int i=indexStart; i<=indexEnd; i++){
             array[i-1] = array[i];
        }
    }

}
