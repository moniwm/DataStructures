package LinkedList;

public class MainTest {

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer>();
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

    }
}
