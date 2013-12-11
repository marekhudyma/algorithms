package mh.algorithms;

public class Sort {

    public static void main(String[] args) {

        int[] array = {1, 8, 4, 5, 10, 3,7, 2, 9, 6};

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

        sort(array);

        System.out.println();
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static int[] sort(int[] array){
        boolean shouldIterate = true;
        while (shouldIterate){
            shouldIterate = false;
            for(int j=0; j<array.length-1; j++){
                if(array[j] > array[j+1])  {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    shouldIterate = true;
                }
            }

        }

        return array;
    }

}
