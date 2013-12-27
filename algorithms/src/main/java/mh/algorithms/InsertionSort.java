package mh.algorithms;

public class InsertionSort implements Sortable {

    @Override
    public void sort(Comparable[] array) {

        for(int j=0; j<array.length; j++) {
            Comparable maxValue = array[0];
            for(int i=0; i<array.length; i++) {
                if(array[i].compareTo(maxValue) < 0) {
                    Comparable tmp = array[i];
                    int index = indexOfFirtElementSmallerThan(array, tmp);
                    moveArrayOneRight(array, index, i);
                    array[index] = tmp;
                }
            }
        }

    }

    private int indexOfFirtElementSmallerThan(Comparable[] array, Comparable value) {
        for(int i=0; i<array.length; i++) {
            if(array[i].compareTo(value) > 0) {
                return i;
            }
        }
        return array.length;
    }

    private void moveArrayOneRight(Comparable[] array, int indexStart, int indexEnd) {
        for(int i=indexEnd; i>indexStart; i--){
             array[i] = array[i-1];
        }
    }

}
