package SortAlgorithms;

import LinkedList.LinkedList;

/**
 *
 * Bubble sort algorithm using Linked Lists
 * @author moniwaterhouse
 * @param <T> is used to implement algorithms
 */

public class BubbleSort<T extends Comparable <T>> {

    private LinkedList<T> list;
    private int listSize;

    public BubbleSort(LinkedList<T> list){

        this.list = list;
        this.listSize = list.getSize();

    }

    public void sort(){

        int end;
        T element1;
        T element2;

        for (end = listSize-1; end >= 1; end--){

            for (int index = 0; index < end; index ++){

                element1 = list.getValue(index);
                element2 = list.getValue(index+1);

                if(element1.compareTo(element2)>0){
                    list.modifyValue(element1,index+1);
                    list.modifyValue(element2,index);
                }

            }
        }

    }

    public LinkedList<T> getSortedList(){
        return list;
    }

}
