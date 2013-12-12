package mh.algorithms;


import junit.framework.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;

public abstract class AbstractSortTest {

    protected Sortable sortable;

    @Test
    public void zeroTest() {
        test(0);
    }

    @Test
    public void smallTest() {
       test(10);
    }

    @Test
    public void averageTest() {
        test(100);
    }

    @Test
    public void bigTest() {
        test(10000);
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() {
        sortable.sort(null);
    }

    private void test(int arraySize) {
        final Integer[] array = randomArray(arraySize);
        final Integer[] array2 =  array.clone();
        Arrays.sort(array);
        long start = System.nanoTime();
        sortable.sort(array2);
        long diff = System.nanoTime() - start;
        Assert.assertTrue(Arrays.equals(array2, array));
        System.out.println(String.format("%s - for %,7d elements execution time=%,14d nanoseconds",
                this.getClass().getSimpleName(), arraySize,diff));
    }

    private Integer[] randomArray(int arraySize) {
        Integer[] array = new Integer[arraySize];
        Random random = new Random();
        for(int i=0; i<arraySize; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

}
