package mh.algorithms;

import junit.framework.Assert;
import org.junit.Test;

public class QuickSortTest extends AbstractSortTest {

    public QuickSortTest() {
        sortable = new QuickSort();
    }

    @Test
    public void test1() {
        final Integer[] array = {6, 1, 7, 2, 5, 8, 1, 4};
        int index = (new QuickSort()).partition(array, 0,7);
        Assert.assertEquals(5, index);
        checkResult(array, 6, 5);
    }

    @Test
    public void test2() {
        final Integer[] array = {4, 1, 1, 2, 5};
        int index = (new QuickSort()).partition(array, 0,4);
        Assert.assertEquals(3, index);
        checkResult(array, 4, 3);
    }

    private void checkResult(Comparable[] array, Comparable pivot, int expectedPivotIndex) {
        for(int i=0; i<expectedPivotIndex; i++){
            Assert.assertTrue(array[i].compareTo(pivot)<0);
        }
        Assert.assertTrue(array[expectedPivotIndex].compareTo(pivot)==0);
        for(int i=expectedPivotIndex+1; i<array.length-1; i++){
            Assert.assertTrue(array[i].compareTo(pivot)>0);
        }
    }
}
