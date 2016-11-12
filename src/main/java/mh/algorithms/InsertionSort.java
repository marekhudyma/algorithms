package mh.algorithms;

/**
 * http://en.wikipedia.org/wiki/Insertion_sort
 *
 * a simple sorting algorithm that builds the final sorted array (or list) one item at a time
 *
 * complexity O(n^2)
 * memory O(1)
 *
 * $current_element = 5,
 * iterate from left and return $index of first element bigger than $current_element.
 * move elements one right from $index, to $current_element_index.
 * put $current_element to $index position
 *
 * example:
 *
 * [5,2,4,6,1,3]
 * current_element = 5,
 * there is no bigger elements on the right, do nothing
 *
 * [5,2,4,6,1,3]
 * current_element = 2,
 * there is bigger element on the left = 5, move 5 one right, put 2 on position [0]
 *
 * [2,5,4,6,1,3]
 * current_element = 4,
 * the bigger element on right [1]=5, move [5] one right, put 4 on position [1]
 *
 * [2,4,5,6,1,3]
 * current_element = 6,
 * there is no bigger elements on the right, do nothing
 *
 * [2,4,5,6,1,3]
 * current_element = 1,
 * the bigger element on right [0]=1, move [2,3,4,6] one right, put 1 on position [0]
 *
 * [1,2,4,5,6,3]
 * current_element = 3,
 * the bigger element on right [2]=4, move [4,5,6] one right, put 1 on position [2]
 *
 * [1,2,3,4,5,6]
 * done
 */
public class InsertionSort implements Sortable {

    @Override
    public void sort(Comparable[] array) {
        for(int i=0; i<array.length; i++) {
            print(array);
            Comparable currentElement = array[i];
            int index = indexOfElementBiggerThanValueFromLeftSide(array, i - 1, currentElement);
            if(index >= 0) {
                moveArrayOneRight(array, index, i -1);
                array[index] = currentElement;
            }
        }
        print(array);
        System.out.println("");
    }

    /**
     * method iterate from beginning of array (included) to indexTo (included)
     * and return index of first bigger element
     * or return -1 if not found
     * @param array
     * @param indexTo
     * @param value
     * @return index of bigger element from the right side or
     *         -1 if no element is smaller
     */
    private int indexOfElementBiggerThanValueFromLeftSide(Comparable[] array, int indexTo, Comparable value) {
        for(int i=0; i<=indexTo; i++) {
            if(array[i].compareTo(value) > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * move array elements one the right from indexStart (included) to indexEnd (included)
     * @param array
     * @param indexStart
     * @param indexEnd
     */
    private void moveArrayOneRight(Comparable[] array, int indexStart, int indexEnd) {
        for(int i=indexEnd; i>=indexStart; i--){
             array[i+1] = array[i];
        }
    }

}
