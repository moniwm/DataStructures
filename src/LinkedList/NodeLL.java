package LinkedList;

/**
 * Node for a Linked list
 *
 * @author moniwaterhouse
 * @param <T> is used to implement generics
 */

public class NodeLL<T extends Comparable<T>> {
    private T value;
    private NodeLL<T> next;

    public NodeLL(T value) {
        this.value = value;
        this.next = null;
    }

    public NodeLL(T value, NodeLL<T> next) {
        this.value = value;
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setNext(NodeLL<T> next) {
        this.next = next;
    }


    public NodeLL<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node: " + value;
    }




}