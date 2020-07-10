package SortAlgorithms;

import LinkedList.LinkedList;

import java.util.Arrays;

/**
 *
 * Radix sort algorithm
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class RadixSort {

    private LinkedList<Integer> list;
    private int listSize;

    public RadixSort(LinkedList<Integer> list){

        this.list = list;
        this.listSize = list.getSize();

    }

    /**
     * Method that returns the maximum value of the elements of the list
     * @return the maximum value found
     */

    public  Integer getMax(){
        Integer max = list.getValue(0);
        for (int i = 1; i<listSize; i++){
            if(list.getValue(i).compareTo(max) > 0){
                max = list.getValue(i);
            }
        }

        return max;
    }

    private void countSort(int n, int exp){

        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (int i = 0; i < n; i++)
            count[ (list.getValue(i)/exp)%10 ]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--)
        {
            output[count[ (list.getValue(i)/exp)%10 ] - 1] = list.getValue(i);
            count[ (list.getValue(i)/exp)%10 ]--;
        }

        for (int i = 0; i < n; i++)
            list.modifyValue(output[i], i);
    }

    public LinkedList<Integer> sort() {
        int max = getMax();

        for (int exp = 1; max/exp > 0; exp *= 10)
            countSort(listSize, exp);

        return list;
    }
}
