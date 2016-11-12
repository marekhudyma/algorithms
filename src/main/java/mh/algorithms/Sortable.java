package mh.algorithms;

import java.util.StringJoiner;

public interface Sortable {

    int MAX_ELEMENTS_TO_PRINT = 15;

    void sort(Comparable[] array);

    default void print(Comparable[] array) {
        if(array.length < MAX_ELEMENTS_TO_PRINT) {
            StringJoiner sj = new StringJoiner(",", "[", "]");
            for (Comparable comparable : array) {
                sj.add(comparable.toString());

            }
            System.out.println(sj.toString());
        }
    }
}
