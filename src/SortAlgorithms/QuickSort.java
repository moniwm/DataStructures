package SortAlgorithms;

import LinkedList.LinkedList;

/**
 * Quick sort algorithm for a linked list
 *
 * @author moniwaterhouse
 * @param <T>
 */

public class QuickSort<T extends Comparable <T>> {

    private LinkedList<T> list;
    private int size;

    public QuickSort(LinkedList<T> list){
        this.list = list;
        this.size = list.getSize();
    }

    public void sort(){
        if(size!=0){
            return;
        }
        else{
            quicksort(0, size-1);
        }
    }

    private void quicksort(int low, int high) {
        int i = low;
        int j = high;

        int pivot = low+(high - low)/2;

        while(i<=j){
            while(list.getValue(i).compareTo(list.getValue(pivot)) < 0){
                i++;
            }
            while(list.getValue(j).compareTo(list.getValue(pivot)) > 0){
                j--;
            }
            if(i<=j){
                exchange (i, j);
                i++;
                j--;
            }
        }

        if(low<j){
            quicksort(low, j);
        }
        if(i < high){
            quicksort(i, high);
        }
    }

    private void exchange(int i, int j) {
        T valueI = list.getValue(i);
        T valueJ = list.getValue(j);

        list.modifyValue(valueI, j);
        list.modifyValue(valueJ, i);
    }

    public LinkedList<T> getSortedList(){
        return this.list;
    }

}
