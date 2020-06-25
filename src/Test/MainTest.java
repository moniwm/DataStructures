package Test;

import DoubleLinkedList.DoubleLinkedList;
import LinkedList.LinkedList;
import DoubleLinkedList.NodeDLL;

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

        System.out.println(lista);*/

        NodeDLL<Integer> nodeDLL = new NodeDLL<Integer>(8);
        System.out.println(nodeDLL);

        nodeDLL.setPrevious(new NodeDLL<Integer>(7));
        System.out.println(nodeDLL.getPrevious());

        nodeDLL.setNext(new NodeDLL<Integer>(9));
        System.out.println(nodeDLL.getNext());
        System.out.println();

    }
}
