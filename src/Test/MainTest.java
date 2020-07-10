package Test;

import LinkedList.LinkedList;
import SortAlgorithms.RadixSort;
import Trees.SplayTree;

import java.util.ArrayList;
import java.util.Random;

public class MainTest {

    public static void main(String[] args) {
        /*LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.addFirst(0);
        lista.addFirst(1);
        lista.addFirst(2);
        lista.addFirst(3);
        lista.addLast(4);
        lista.addLast(5);
        lista.addLast(6);

        lista.insertElement(7,3);

        System.out.println(lista);

        lista.deleteFirst();

        System.out.println(lista);

        lista.deleteLast();
        lista.deleteLast();

        System.out.println(lista);

        lista.deleteElement(2);

        System.out.println(lista);

        lista.deleteElementIndex(1);

        System.out.println(lista);

        lista.modifyValue(7,1);

        System.out.println(lista);

        BinaryTree<Integer> bst = new BinaryTree<>();
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.insert(7);

        bst.getRootValue();

        AVLTree<Integer> avl = new AVLTree<>();
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);


        avl.getRootValue();
        avl.printInOrder();

        avl.remove(4);

        avl.getRootValue();

        avl.printInOrder();*/

        LinkedList<Integer> list = new LinkedList<Integer>();
        Random random = new Random();

        for(int i = 0; i<20; i++){

            int num = random.nextInt(500);
            list.addLast(num);
        }

        for (int i = 0; i <list.getSize(); i++){
            System.out.println(list.getValue(i));

        }

        RadixSort radixSort = new RadixSort(list);
        list = radixSort.sort();

        for (int i = 0; i <list.getSize(); i++){
            System.out.println(list.getValue(i));

        }

    }
}
